package com.orienit.spark.training.scala

import scala.xml.XML

import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object XmlProcessing {

  def main(arg: Array[String]) {

    var logger = Logger.getLogger(this.getClass())

    if (arg.length < 2) {
      logger.error("=> wrong parameters number")
      System.err.println("Usage: XmlProcessing <path-to-files> <output-path>")
      System.exit(1)
    }

    val jobName = "XmlProcessing"

    val conf = new SparkConf().setAppName(jobName)
    conf.set("spark.hadoop.validateOutputSpecs", "false")

    val sc = new SparkContext(conf)

    val pathToFiles = arg(0)
    val outputPath = arg(1)

    logger.info("=> jobName \"" + jobName + "\"")
    logger.info("=> pathToFiles \"" + pathToFiles + "\"")

    val tradeXML = XML.loadFile(pathToFiles)

    val header = "Stock Id" + "\t" + "stock name" + "\t" + "open price" + "\t" + "intraday high" + "\t" + "intraday_low" + "\t" + "publish data"
    var rows: List[String] = List(header)

    for (tradedata <- tradeXML \ "stock") {
      val stock_id = (tradedata \ "@id")
      val stock_name = (tradedata \ "stock_name").text
      val open_price = (tradedata \ "open_price").text
      val intraday_high = (tradedata \ "intraday_high").text
      val intraday_low = (tradedata \ "intraday_low").text
      val publish_date = (tradedata \ "publish_date").text

      val row = stock_id + "\t" + stock_name + "\t" + open_price + "\t" + intraday_high + "\t" + intraday_low + "\t" + publish_date
      val myrow: List[String] = List(row)
      rows = rows ::: myrow
    }

    val x = sc.parallelize(rows)
    x.saveAsTextFile(outputPath)
  }
}
