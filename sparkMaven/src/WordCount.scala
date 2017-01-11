

import org.apache.spark._
import SparkContext._
object WordCount {
    def main(args: Array[String]) {
        var args = Array("spark://master-renho.hadoop:7077", "file:///d:/renho.txt", "file:///d:/renhox");
        if (args.length != 3) {
            println("usage is org.test.WordCount <master> <input> <output>")
            return
        }
        val sc = new SparkContext(args(0), "WordCount")
        sc.addJar("file:///C://Users//renho//Desktop//spark-wordcount-in-scala-win.jar");
        val textFile = sc.textFile(args(1))
        val result = textFile.flatMap(line => line.split("\\s+")).map(word => (word, 1)).reduceByKey(_ + _)
        result.saveAsTextFile(args(2))
    }
}