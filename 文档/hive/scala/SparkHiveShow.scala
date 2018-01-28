package com.renho.sparkhive

import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object SparkHiveShow {
  def main(args: Array[String]): Unit = {
    var conf = new SparkConf()
    conf.setAppName("Spark-Hive")
    conf.setMaster("spark://master:7077")
    var sc = new SparkContext(conf)
    sc.addJar("file:///Users/renho/workspace/spark-deploy/spark-hive/spark-hive.jar")
    val hiveCotext = new HiveContext(sc)
    println(1231111111)
    val tc = hiveCotext.sql("select * from renho_test")
    tc.collect().foreach(println)
    sc.stop()
  }
}
