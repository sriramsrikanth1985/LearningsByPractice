package com.orienit.spark.training.kalyan.sql

import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.cassandra._
import com.datastax.spark.connector._
import com.datastax.spark.connector.cql.CassandraConnector

object KalyanCassandraExamples extends App {
  val sparkConf = new SparkConf().setAppName("Kalyan Cassandra Examples").setMaster("local")
  val conf = sparkConf.set("spark.cassandra.connection.host", "127.0.0.1").set("spark.cassandra.input.split.size_in_mb", "268435456")
  val sc = new SparkContext(conf)
  val sqlContext = new SQLContext(sc)

  /*

    CREATE KEYSPACE kalyan WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1 };
    
    CREATE TABLE kalyan.student(name text PRIMARY KEY, id int, course text, year int);
    
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('anil', 1, 'spark', 2016);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('venkat', 2, 'spark', 2016);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('raj', 3, 'spark', 2016);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('sunil', 4, 'hadoop', 2015);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('anvith', 5, 'hadoop', 2015);
    INSERT INTO kalyan.student(name, id, course, year) VALUES ('dev', 6, 'hadoop', 2015);
    
    SELECT * FROM kalyan.student;
  
   */

  /*******************************************************************************/

  // load data from kalyan.student table as a DataFrame
  val df = sqlContext.read.cassandraFormat("student", "kalyan").load()

  // display the result
  df.show()

  /*******************************************************************************/

  // register DataFrame as a student Table
  df.createOrReplaceTempView("student")

  // create a DataFrame from kalyan.student table
  val df1 = sqlContext.sql("SELECT * from student")

  // display the result
  df1.show()

  /*******************************************************************************/

  val students = List(("rajesh", 11, "spark", 2016), ("nagesh", 12, "spark", 2016), ("ganesh", 13, "spark", 2016))

  val rdd = sc.parallelize(students)

  // CREATE TABLE kalyan.student(name text PRIMARY KEY, id int, course text, year int);

  // save the DataFrame into kalyan.student1 table
  rdd.saveToCassandra("kalyan", "student1", SomeColumns("name", "id", "course", "year"))

  /*******************************************************************************/

  // create a RDD from kalyan.student1 table
  val rdd1 = sc.cassandraTable("kalyan", "student1")

  // display the result
  rdd1.foreach(println)

  /*******************************************************************************/

  sc.stop()
}