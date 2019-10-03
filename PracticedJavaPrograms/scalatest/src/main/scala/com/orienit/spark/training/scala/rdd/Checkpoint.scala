package com.orienit.spark.training.scala.rdd

import org.apache.spark.SparkContext

object Checkpoint {
  def main(args: Array[String]) {
	  val sc = new SparkContext("local", "Checkpoint Test") 
	  
	  sc.setCheckpointDir("/home/orienit/spark/data/checkpoint")
	  val a = sc.parallelize(1 to 4, 2)
	  a.checkpoint
	  a.count
  }
}