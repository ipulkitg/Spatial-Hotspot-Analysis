package cse511

object HotzoneUtils {
  def ST_Contains(queryRectangle: String, pointString: String): Boolean = {
  def isInvalid(input: String): Boolean = input == null || input.trim.length == 0

  if (isInvalid(queryRectangle) || isInvalid(pointString)) return false

  val rect = queryRectangle.split(",").map(_.trim)
  val point = pointString.split(",").map(_.trim)

  if (rect.length < 4 || point.length < 2) return false

  val coords = rect.take(4).map(_.toDouble)
  val px = point(0).toDouble
  val py = point(1).toDouble

  val xRange = (coords(0) min coords(2), coords(0) max coords(2))
  val yRange = (coords(1) min coords(3), coords(1) max coords(3))

  (px >= xRange._1 && px <= xRange._2) &&
  (py >= yRange._1 && py <= yRange._2)
 }
   
}
