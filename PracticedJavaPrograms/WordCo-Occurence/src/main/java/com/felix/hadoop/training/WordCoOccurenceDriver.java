package com.felix.hadoop.training;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class WordCoOccurenceDriver extends Configured implements Tool{

	public static void main(String[] args) throws Exception
	{
		ToolRunner.run(new WordCoOccurenceDriver(),args);
	}

	@Override
	public int run(String[] args) throws Exception {

		Job job = new Job(getConf(),"WordCo-Occurence Job");
		job.setJarByClass(WordCoOccurenceDriver.class);
		
		job.setMapperClass(WordCoOccurenceMapper.class);
		job.setReducerClass(WordCoOccurenceReducer.class);

		job.setInputFormatClass(TextInputFormat.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);



		return 0;
	}


}
