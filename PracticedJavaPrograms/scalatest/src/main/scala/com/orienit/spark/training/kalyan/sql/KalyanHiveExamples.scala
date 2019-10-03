package com.orienit.spark.training.kalyan.sql

import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.hive._

object KalyanHiveExamples extends App {
  val sparkConf = new SparkConf().setAppName("Kalyan Examples").setMaster("local")
  val sc = new SparkContext(sparkConf)
  val sqlContext = new SQLContext(sc)
  val hiveContext = new HiveContext(sc)

  /*******************************************************************************/

  hiveContext.sql("CREATE DATABASE IF NOT EXISTS kalyan")
  hiveContext.sql("CREATE TABLE IF NOT EXISTS kalyan.student (name STRING, id INT, course STRING, year INT) ROW FORMAT DELIMITED FIELDS TERMINATED BY ','")
  hiveContext.sql("LOAD DATA LOCAL INPATH '/home/orienit/spark/input/student.csv' INTO TABLE kalyan.student")

  /*******************************************************************************/

  // load data from kalyan.student table as a DataFrame
  val df = sqlContext.sql("SELECT * from kalyan.student")

  // display the result
  df.show()

  /*******************************************************************************/

  // save the DataFrame into kalyan.student1 table
  df.write.saveAsTable("kalyan.student1")

  /*******************************************************************************/

  // load data from kalyan.student1 table as a DataFrame
  val df1 = sqlContext.sql("SELECT * from kalyan.student1")

  // display the result
  df1.show()

  /*******************************************************************************/

  sc.stop()
}