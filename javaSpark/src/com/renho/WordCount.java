package com.renho;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: zarchary Date: 14-1-19 Time: ÏÂÎç6:23 To
 * change this template use File | Settings | File Templates.
 */
public final class WordCount {

	public static void main(String[] args) throws Exception {
		JavaSparkContext ctx = new JavaSparkContext("spark://192.168.0.107:7077", "WordCount",
				"/root/spark-1.5.2-bin-hadoop2.6", "C://Users//renho//Desktop//spark-wordcount-in-java.jar");
		JavaRDD<String> lines = ctx.textFile("hdfs://192.168.0.107:9000/porrylee/input/file1.txt", 1);

		JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
			public Iterable<String> call(String s) {
				return Arrays.asList(s.split(" "));
			}
		});
		System.out.println("====words:" + words.count());

		JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
			public Tuple2<String, Integer> call(String s) {
				return new Tuple2<String, Integer>(s, 1);
			}
		});

		JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
			public Integer call(Integer i1, Integer i2) {
				return i1 + i2;
			}
		});
		System.out.println("====½á¹û:" + counts.count());

		// List<Tuple2<String, Integer>> output = counts.collect();
		// for (Tuple2 tuple : output) {
		// System.out.println(tuple._1 + ": " + tuple._2);
		// }
		System.exit(0);
	}

}