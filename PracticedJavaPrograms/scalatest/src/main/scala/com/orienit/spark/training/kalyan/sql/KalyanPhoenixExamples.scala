package com.orienit.spark.training.kalyan.sql

import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.types._
import org.apache.spark.rdd.RDD
import org.apache.phoenix.spark._
import org.apache.hadoop.conf.Configuration

object KalyanPhoenixExamples extends App {
  val sparkConf = new SparkConf().setAppName("Kalyan Phoenix Examples").setMaster("local")
  val sc = new SparkContext(sparkConf)
  val sqlContext = new SQLContext(sc)

  /*
    CREATE TABLE STUDENT(name VARCHAR PRIMARY KEY, id INTEGER, course VARCHAR, year INTEGER);
    
    UPSERT INTO STUDENT(name, id, course, year) VALUES ('anil', 1, 'spark', 2016);
    UPSERT INTO STUDENT(name, id, course, year) VALUES ('venkat', 2, 'spark', 2016);
    UPSERT INTO STUDENT(name, id, course, year) VALUES ('raj', 3, 'spark', 2016);
    UPSERT INTO STUDENT(name, id, course, year) VALUES ('sunil', 4, 'hadoop', 2015);
    UPSERT INTO STUDENT(name, id, course, year) VALUES ('anvith', 5, 'hadoop', 2015);
    UPSERT INTO STUDENT(name, id, course, year) VALUES ('dev', 6, 'hadoop', 2015);
    
    SELECT * FROM STUDENT;
    
   */

  /*******************************************************************************/

  // load data from STUDENT table as a DataFrame
  val df = sqlContext.load("org.apache.phoenix.spark",
    Map("table" -> "STUDENT", "zkUrl" -> "localhost:2181"))

  // display the result
  df.show()

  /*******************************************************************************/

  // CREATE TABLE STUDENT1(name VARCHAR PRIMARY KEY, id INTEGER, course VARCHAR, year INTEGER);

  // save the DataFrame into STUDENT1 table
  df.write.format("org.apache.phoenix.spark")
    .mode(SaveMode.Overwrite)
    .options(Map("table" -> "STUDENT1", "zkUrl" -> "localhost:2181"))
    .save()

  /*******************************************************************************/

  // CREATE TABLE STUDENT2(name VARCHAR PRIMARY KEY, id INTEGER, course VARCHAR, year INTEGER);

  // save the DataFrame into STUDENT2 table
  df.saveToPhoenix("STUDENT2", new Configuration, Some("localhost:2181"))

  /*******************************************************************************/

  val configuration = new Configuration()

  /*******************************************************************************/

  // load data from STUDENT table as a DataFrame
  val df1 = sqlContext.phoenixTableAsDataFrame(
    "STUDENT", Seq[String](), zkUrl = Some("localhost:2181"), conf = configuration)

  // display the result
  df1.show()

  /*******************************************************************************/

  // load data from STUDENT table with specific columns as a DataFrame
  val df2 = sqlContext.phoenixTableAsDataFrame(
    "STUDENT", Seq[String]("ID", "NAME"), zkUrl = Some("localhost:2181"), conf = configuration)

  // display the result
  df2.show()

  /*******************************************************************************/

  val students = List(("rajesh", 11, "spark", 2016), ("nagesh", 12, "spark", 2016), ("ganesh", 13, "spark", 2016))

  val rdd = sc.parallelize(students)

  // CREATE TABLE STUDENT3(name VARCHAR PRIMARY KEY, id INTEGER, course VARCHAR, year INTEGER);

  // save the DataFrame into STUDENT3 table
  rdd.saveToPhoenix("STUDENT3", Seq("NAME", "ID", "COURSE", "YEAR"), zkUrl = Some("localhost:2181"))

  /*******************************************************************************/

  // load data from STUDENT3 table as a RDD
  val rdd1 = sc.phoenixTableAsRDD(
    "STUDENT3", Seq[String](), zkUrl = Some("localhost:2181"), conf = configuration)

  // display the result
  rdd1.foreach(println)

  /*******************************************************************************/

  // load data from STUDENT3 table with specific columns as a RDD
  val rdd2 = sc.phoenixTableAsRDD(
    "STUDENT3", Seq[String]("ID", "NAME"), zkUrl = Some("localhost:2181"), conf = configuration)

  // display the result
  rdd2.foreach(println)

  /*******************************************************************************/

  sc.stop()
}