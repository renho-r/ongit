package com.renho.hadoop.score;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ScoreAvg {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Job job = Job.getInstance();
		
		job.setJarByClass(ScoreAvg.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.setInputPaths(job, new Path("score_in"));
		FileOutputFormat.setOutputPath(job, new Path("score_out"));
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}

class Map extends Mapper<Object, Text, Text, IntWritable> {
	@Override
	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		StringTokenizer st = new StringTokenizer(value.toString());
		context.write(new Text(st.nextToken()), new IntWritable(Integer.valueOf(st.nextToken())));
	}
}

class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		int sum = 0;
		int i = 0;
		for(IntWritable iw:values) {
			sum += iw.get();
			i++;
		}
		context.write(key, new IntWritable(sum/i));
	}
	
}