package com.orienit.spark.training.scala

import org.apache.spark.Partitioner
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

import com.orienit.spark.training.scala.WordCountPartitioner;

class WordCountPartitioner(partitions: Int) extends Partitioner {
  def numPartitions: Int = partitions

  def getPartition(key: Any): Int = {
    val word = key.toString().toLowerCase()
    val firstChar = word.charAt(0)
    val diff = Math.abs(firstChar - 'a') % numPartitions
    diff
  }
}

object WordCountPartitioner extends App {
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
  val groups = wordlist.partitionBy(new WordCountPartitioner(26))
  groups.foreach(println)
}