# Spatial Hotspot Analysis

Advanced spatial analytics for NYC taxi data to identify passenger pickup hotspots using statistical methods.

## Overview
Implementation of two hotspot detection algorithms for taxi service optimization: Hot Zone Analysis and Hot Cell Analysis with Getis-Ord Gi* statistics.

## Features
- **Hot Zone Analysis**: Rectangle-based hotspot detection using range joins
- **Hot Cell Analysis**: Statistically significant hotspot identification using Getis-Ord Gi* z-scores
- **Spatio-temporal Analysis**: Process monthly taxi datasets (2009-2012)
- **Statistical Computing**: Implement spatial statistics for big data

## Analysis Types

### Hot Zone Analysis
- Range join operations on rectangle and point datasets
- Calculate hotness by counting points within rectangles
- Output zones sorted by rectangle coordinates

### Hot Cell Analysis  
- Apply Getis-Ord Gi* statistic to NYC taxi trip data
- Identify statistically significant spatial hotspots
- Cell grid: 0.01° x 0.01° latitude/longitude
- Time step: 1 day intervals

## Files
- `HotzoneAnalysis.scala` / `HotzoneUtils.scala` - Hot zone implementation
- `HotcellAnalysis.scala` / `HotcellUtils.scala` - Hot cell implementation
- `Main.scala` - Application entry point
- `CSE511-assembly-0.1.0.jar` - Compiled application

## Usage
```bash
# Compile
sbt assembly

# Run both analyses
spark-submit target/scala-2.11/CSE511-Hotspot-Analysis-assembly-0.1.0.jar result/output \
  hotzoneanalysis src/resources/point-hotzone.csv src/resources/zone-hotzone.csv \
  hotcellanalysis src/resources/yellow-trip-sample-100000.csv
```

## Output
- Results exported as CSV files in `result/output/` directory
- Hot zone analysis: Rectangle coordinates with hotness scores
- Hot cell analysis: Top 50 hotspot coordinates ranked by G-score

## Requirements
- Apache Spark 2.x
- Scala 2.11
- NYC Taxi Dataset (2009-2012)

**Tech Stack**: Apache Spark, Scala, Spatial Statistics, Geospatial Analysis