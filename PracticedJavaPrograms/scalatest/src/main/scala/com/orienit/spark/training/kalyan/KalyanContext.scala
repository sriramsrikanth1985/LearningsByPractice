package com.orienit.spark.training.kalyan

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.DataFrame

class KalyanContext(sparkContext: SparkContext, filePath: String) extends SQLContext(sparkContext) {
  def createDataFrame(): DataFrame = {
    val sqlContext = new SQLContext(sparkContext)

    // find the type of the file
    val pos = filePath.lastIndexOf(".")
    val fileType = if (pos != -1) filePath.substring(pos) else ""

    // create data frame using fileType 
    if (fileType.equals("orc")) {
      sqlContext.read.format("orc").load(filePath)
    } else if (fileType.equals("json")) {
      sqlContext.read.format("json").load(filePath)
    } else if (fileType.equals("parquet")) {
      sqlContext.read.format("parquet").load(filePath)
    } else {
      sqlContext.read.format("text").load(filePath)
    }
  }
}