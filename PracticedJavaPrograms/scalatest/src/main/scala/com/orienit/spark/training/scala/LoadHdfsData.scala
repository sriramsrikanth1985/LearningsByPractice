package com.orienit.spark.training.scala

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object HdfsPractice {

  def main(args: Array[String]) {

    val pathToFiles = args(0)
    val outputPath = args(1)

    // configuration
    val sparkConf = new SparkConf()
      .setAppName("Sample")
      .setMaster("local")

    sparkConf.set("spark.hadoop.validateOutputSpecs", "false")

    val sc = new SparkContext(sparkConf)

    val lines = sc.textFile(pathToFiles)

    lines.foreach(println)

  }
}