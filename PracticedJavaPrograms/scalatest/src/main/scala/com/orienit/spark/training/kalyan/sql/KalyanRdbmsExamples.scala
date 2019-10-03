package com.orienit.spark.training.kalyan.sql

import org.apache.spark._
import org.apache.spark.sql._

object KalyanRdmbsExamples extends App {
  val sparkConf = new SparkConf().setAppName("Kalyan Examples").setMaster("local")
  val sc = new SparkContext(sparkConf)
  val sqlContext = new SQLContext(sc)

  /*
    mysql -u root -p
    
    CREATE DATABASE IF NOT EXISTS kalyan;
    
    CREATE TABLE kalyan.student(name VARCHAR(50) PRIMARY KEY, id INT, course VARCHAR(50), year INT);
    
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('anil', 1, 'spark', 2016);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('venkat', 2, 'spark', 2016);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('raj', 3, 'spark', 2016);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('sunil', 4, 'hadoop', 2015);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('anvith', 5, 'hadoop', 2015);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('dev', 6, 'hadoop', 2015);
    
    SELECT * FROM kalyan.student;
   */

  /*******************************************************************************/

  val prop = new java.util.Properties
  prop.setProperty("driver", "com.mysql.jdbc.Driver")
  prop.setProperty("user", "root")
  prop.setProperty("password", "hadoop")

  // load data from kalyan.student table as a DataFrame
  val df = sqlContext.read.jdbc("jdbc:mysql://localhost:3306/kalyan", "student", prop)

  // display the result
  df.show()

  /*******************************************************************************/

  // save the DataFrame into kalyan.student1 table
  df.write.jdbc("jdbc:mysql://localhost:3306/kalyan", "student1", prop)

  /*******************************************************************************/

  // load data from kalyan.student1 table as a DataFrame
  val df1 = sqlContext.read.jdbc("jdbc:mysql://localhost:3306/kalyan", "student1", prop)

  // display the result
  df1.show()

  /*******************************************************************************/

  sc.stop()
}