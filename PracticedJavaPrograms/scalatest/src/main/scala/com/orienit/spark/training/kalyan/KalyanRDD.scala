package com.orienit.spark.training.kalyan

import org.apache.spark.Partition
import org.apache.spark.SparkContext
import org.apache.spark.TaskContext
import org.apache.spark.rdd.RDD

case class Kalyan(number: Int) {
  override def toString(): String = number.toString()
}

class KalyanRDD(rdd: RDD[Kalyan], num: Int) extends RDD[Kalyan](rdd) {

  override def compute(split: Partition, context: TaskContext): Iterator[Kalyan] = {
    firstParent[Kalyan].iterator(split, context).map(x => Kalyan(x.number * num))
  }

  override def getPartitions: Array[Partition] = {
    firstParent[Kalyan].partitions
  }

  def myCount() = rdd.count()

  def myRepartition(numPartitions: Int) = rdd.repartition(numPartitions)

}


