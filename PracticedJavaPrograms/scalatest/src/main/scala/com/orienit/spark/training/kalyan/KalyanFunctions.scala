package com.orienit.spark.training.kalyan

import org.apache.spark.rdd.RDD

class KalyanFunctions[T](rdd: RDD[T]) {
  def myCount() = rdd.count()

  def myRepartition(numPartitions: Int) = rdd.repartition(numPartitions)
}

object KalyanFunctions {
  implicit def addKalyanFunctions[T](rdd: RDD[T]) = new KalyanFunctions(rdd)
}