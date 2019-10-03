package com.orienit.spark.training.kalyan

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object KalyanExamples2 extends App {
  val sparkConf = new SparkConf().setAppName("Kalyan Examples").setMaster("local")
  val sc = new SparkContext(sparkConf)
  val rdd = sc.parallelize(List(1, 2, 3, 4, 5), 5)
  println(rdd.count())
  // println(rdd.myCount())

  val klist = rdd.map { x => Kalyan(x) }
  val kRdd = new KalyanRDD(klist, 3)
  println(kRdd.count())
  kRdd.foreach(println)

  println(kRdd.myCount())

  sc.stop()
}