package com.orienit.spark.training.scala

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {
    def main(args: Array[String]): Unit = {
  if (args.length < 1) {
    System.err.println("Usage: WordCount <file>")
    System.exit(1)
  }

  val conf = new SparkConf()
    .setAppName("Word Count")
    .setMaster("local")

  val sc = new SparkContext(conf)

  val textFile = sc.textFile(args(0))
  val words = textFile.flatMap(line => line.split(" "))
  val wordlist = words.map(word => (word, 1))
  val groups = wordlist.reduceByKey(_ + _)

  groups.foreach(println)
    }
}