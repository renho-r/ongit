package com.renho;

/**
 * User: hadoop
 * Date: 2014/10/10 0010
 * Time: 19:26
 */

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class JavaWordCount {
	private static final Pattern SPACE = Pattern.compile(" ");

	public static void main(String[] args) throws Exception {
//		args = new String[]{"C:/Users/renho/Desktop/renho.txt"};
//		args = new String[]{"file:///C:/Users/renho/Desktop/renho.txt"};
//		args = new String[]{"file:///root/renho.txt"};
//		args = new String[]{"hdfs://master-renho.hadoop:9000/porrylee/input/environment"};
		if (args.length < 1) {
			System.err.println("Usage: JavaWordCount <file>");
			System.exit(1);
		}
		System.setProperty("user.name","root");
		SparkConf sparkConf = new SparkConf().setAppName("JavaWordCount");
//		JavaSparkContext ctx = new JavaSparkContext("spark://master-renho.hadoop:7077", "JavaWordCount", sparkConf);
		JavaSparkContext ctx = new JavaSparkContext("spark://master-renho.hadoop:7077", "JavaWordCount", "/root/spark-1.5.1-bin-hadoop2.6", JavaSparkContext.jarOfClass(JavaWordCount.class));  
		ctx.addJar("file:///C:/Users/renho/Desktop/spark-wordcount-in-java-win.jar");
		JavaRDD<String> lines = ctx.textFile(args[0], 1);
		

		JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
			@Override
			public Iterable<String> call(String s) {
				return Arrays.asList(SPACE.split(s));
			}
		});

		JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
			@Override
			public Tuple2<String, Integer> call(String s) {
				return new Tuple2<String, Integer>(s, 1);
			}
		});

		JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
			@Override
			public Integer call(Integer i1, Integer i2) {
				return i1 + i2;
			}
		});

		List<Tuple2<String, Integer>> output = counts.collect();
		for (Tuple2<?, ?> tuple : output) {
			System.out.println(tuple._1() + ": " + tuple._2());
		}
		ctx.stop();
	}
}