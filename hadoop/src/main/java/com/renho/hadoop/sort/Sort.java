package com.renho.hadoop.sort;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Sort {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		args = new String[2];
		
		args[0] = "sort_in";
		args[1] = "sort_out";
		
		Job job = Job.getInstance();
		job.setJarByClass(Sort.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}

class Map extends Mapper<Object, Text, IntWritable, IntWritable> {
	private static IntWritable data = new IntWritable();
	@Override
	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		data.set(Integer.valueOf(line));
		context.write(data, new IntWritable(1));
	}
	
}

class Reduce extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {

	private static IntWritable linenum = new IntWritable(1);
	
	@Override
	protected void reduce(IntWritable key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		for(IntWritable val:values){
            context.write(linenum, key);
            linenum = new IntWritable(linenum.get() + 1);
        }
	}
	
}