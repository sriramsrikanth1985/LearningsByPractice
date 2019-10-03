package com.orienit.spark.training.scala.graphx

import org.apache.spark.SparkContext._
import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD

object GraphExamples {

  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("GraphExamples").setMaster("local")
    val sc = new SparkContext(conf)

    // Load the edges as a graph
    val graph = GraphLoader.edgeListFile(sc, "file:/home/orienit/spark/input/graphx/followers.txt")

    // Load usernames from separate file
    val users = sc.textFile("file:/home/orienit/spark/input/graphx/users.txt").map { line =>
      val fields = line.split(",")
      (fields(0).toLong, fields(1))
    }

    // Run PageRank
    val ranks = graph.pageRank(0.0001).vertices

    println("\n\n~~~~~~~~~ PageRank Vetices result ~~~~~~~~~")
    println(ranks.collect().mkString("\n"))

    // Join the ranks with the usernames
    val ranksByUsername = users.join(ranks).map {
      case (id, (username, rank)) => (username, rank)
    }

    // Find the connected components
    val cc = graph.connectedComponents().vertices

    // Join CCs with the usernames
    val ccByUsername = users.join(cc).map {
      case (id, (username, cc)) => (username, cc)
    }

    // Print pagerank result
    println("\n\n~~~~~~~~~ Print pagerank result ~~~~~~~~~")
    println(ranksByUsername.sortBy(-_._2).collect().mkString("\n"))

    // Print Connected Components result
    println("\n\n~~~~~~~~~ Print Connected Components result ~~~~~~~~~")
    println(ccByUsername.sortBy(_._2).collect().mkString("\n"))

   
    // Load the edges in canonical order and partition the graph for triangle count
    val tgraph = GraphLoader.edgeListFile(sc, "file:/home/orienit/spark/input/graphx/followers.txt", true).partitionBy(PartitionStrategy.RandomVertexCut)

    // Find the triangle count for each vertex
    val triCounts = tgraph.triangleCount().vertices

    // Join the triangle counts with the usernames
    val tusers = sc.textFile("file:/home/orienit/spark/input/graphx/users.txt").map { line =>
      val fields = line.split(",")
      (fields(0).toLong, fields(1))
    }

    // Join the triangle counts with the usernames
    val triCountByUsername = tusers.join(triCounts).map {
      case (id, (username, tc)) =>
        (username, tc)
    }

    // Print Triangle Counting result
    println("\n\n~~~~~~~~~ Print Triangle Counting result ~~~~~~~~~")
    println(triCountByUsername.sortBy(_._2).collect().mkString("\n"))

    sc.stop()
  }
}
