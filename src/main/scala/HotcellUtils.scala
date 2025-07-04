package cse511

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar

object HotcellUtils {
  val coordinateStep = 0.01

  def CalculateCoordinate(inputString: String, coordinateOffset: Int): Int =
  {
    // Configuration variable:
    // Coordinate step is the size of each cell on x and y
    var result = 0
    coordinateOffset match
    {
      case 0 => result = Math.floor((inputString.split(",")(0).replace("(","").toDouble/coordinateStep)).toInt
      case 1 => result = Math.floor(inputString.split(",")(1).replace(")","").toDouble/coordinateStep).toInt
      // We only consider the data from 2009 to 2012 inclusively, 4 years in total. Week 0 Day 0 is 2009-01-01
      case 2 => {
        val timestamp = HotcellUtils.timestampParser(inputString)
        result = HotcellUtils.dayOfMonth(timestamp) // Assume every month has 31 days
      }
    }
    return result
  }

  def timestampParser (timestampString: String): Timestamp =
  {
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val parsedDate = dateFormat.parse(timestampString)
    val timeStamp = new Timestamp(parsedDate.getTime)
    return timeStamp
  }

  def dayOfYear (timestamp: Timestamp): Int =
  {
    val calendar = Calendar.getInstance
    calendar.setTimeInMillis(timestamp.getTime)
    return calendar.get(Calendar.DAY_OF_YEAR)
  }

  def dayOfMonth (timestamp: Timestamp): Int =
  {
    val calendar = Calendar.getInstance
    calendar.setTimeInMillis(timestamp.getTime)
    return calendar.get(Calendar.DAY_OF_MONTH)
  }

  // YOU NEED TO CHANGE THIS PART
  def calculateNumberOfAdjacentCells(minX: Int, maxX: Int, minY: Int, maxY: Int, minZ: Int, maxZ: Int, X: Int, Y: Int, Z: Int): Int = {
  val boundaryFlags = List(
    X == minX || X == maxX,
    Y == minY || Y == maxY,
    Z == minZ || Z == maxZ
  )

  val boundaryCount = boundaryFlags.count(identity)

  val adjacentCellMap = Map(
    0 -> 26,
    1 -> 17,
    2 -> 11,
    3 -> 7
  )

  adjacentCellMap.getOrElse(boundaryCount, 0)
 }
 def calculateGScore(numCells: Int, x: Int, y: Int, z: Int, adjacentSum: Int, cellCount: Int, avg: Double, stdDev: Double): Double = {
  val numerator = cellCount - avg * adjacentSum
  val denominator = stdDev * math.sqrt(
    (numCells * adjacentSum - math.pow(adjacentSum, 2)) / (numCells - 1)
  )
  numerator / denominator
 } 
}
