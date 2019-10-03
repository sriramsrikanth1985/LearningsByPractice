package com.orienit.spark.training.kalyan

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object KalyanExamples1 extends App {
  val sparkConf = new SparkConf().setAppName("Kalyan Examples").setMaster("local")
  val sc = new SparkContext(sparkConf)
  val rdd = sc.parallelize(List(1, 2, 3, 4), 5)
  println(rdd.count())
  // println(rdd.myCount())

  import KalyanFunctions._

  println(rdd.myCount())

  println(rdd.getNumPartitions)

  println(rdd.myRepartition(1).getNumPartitions)

  sc.stop()
}