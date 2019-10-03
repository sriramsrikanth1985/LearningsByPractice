

import org.apache.spark._
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object ReadFromFileSpark {
  def main(args: Array[String]): Unit = {
    println("Hello Sriram !!")
    
    val sconf = new SparkConf().setMaster("local[*]").setAppName("HelloWorld")
    val sc = new SparkContext(sconf)
    sc.setLogLevel("ERROR")
    
    val revenuePerOrder = sc.textFile("C:\\Ddrive\\Personal\\Hadoop\\downloads\\data-master\\retail_db\\order_items", 2)
    .map(rec => (rec.split(",")(1).toInt,rec.split(",")(4).toFloat))
    .reduceByKey(_+_)
    .map(rec => rec._1+","+rec._2)
    
    revenuePerOrder.saveAsTextFile("C:\\Ddrive\\output")
    
  }
}