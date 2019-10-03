package com.orienit.spark.training.scala

import scala.xml.XML

import org.apache.hadoop.io.Text
import org.apache.hadoop.mapred.FileInputFormat
import org.apache.hadoop.mapred.JobConf
import org.apache.hadoop.streaming.StreamInputFormat
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object TradeData {

  def main(args: Array[String]) {

    val pathToFiles = args(0)
    val outputPath = args(1)

    // configuration
    val sparkConf = new SparkConf()
      .setAppName("TradeData")
      .setMaster("local")

    sparkConf.set("spark.hadoop.validateOutputSpecs", "false")

    val jobConf = new JobConf()
    jobConf.set("stream.recordreader.class", "org.apache.hadoop.streaming.StreamXmlRecordReader")
    jobConf.set("stream.recordreader.begin", "<tradedata>")
    jobConf.set("stream.recordreader.end", "</tradedata>")
    FileInputFormat.addInputPaths(jobConf, pathToFiles)

    val sparkContext = new SparkContext(sparkConf)

    // read data
    val xmldata = sparkContext.hadoopRDD(
      jobConf,
      classOf[org.apache.hadoop.streaming.StreamInputFormat],
      classOf[Text],
      classOf[Text])

    val header = "Stock Id" + "\t" + "stock name" + "\t" + "open price" + "\t" + "intraday high" + "\t" + "intraday_low" + "\t" + "publish data"
    var rows: List[String] = List(header)

    val xml = xmldata.map(_._1.toString)
    val f = xml.first
    val tradeXML = XML.loadString(f)
    val tradedata = tradeXML \ "stock"

    val mydata = tradedata.map { x =>
      val stock_id = (x \ "@id")
      val stock_name = (x \ "stock_name").text
      val open_price = (x \ "open_price").text
      val intraday_high = (x \ "intraday_high").text
      val intraday_low = (x \ "intraday_low").text
      val publish_date = (x \ "publish_date").text
      val row = stock_id + "\t" + stock_name + "\t" + open_price + "\t" + intraday_high + "\t" + intraday_low + "\t" + publish_date
      (row)
    }

    val x = sparkContext.parallelize(mydata)
    x.saveAsTextFile(outputPath)

  }
}