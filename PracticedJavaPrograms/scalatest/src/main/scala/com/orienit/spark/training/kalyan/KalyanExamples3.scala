package com.orienit.spark.training.kalyan

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object KalyanExamples3 extends App {
  val sparkConf = new SparkConf().setAppName("Kalyan Examples").setMaster("local")
  val sc = new SparkContext(sparkConf)
  val kc = new KalyanContext(sc, "/home/orienit/work/input/demoinput")
  val df = kc.createDataFrame()
  df.show
}