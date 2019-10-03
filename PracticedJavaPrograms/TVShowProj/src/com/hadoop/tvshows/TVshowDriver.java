package com.hadoop.tvshows;

import org.apache.hadoop.conf.Configuration;
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

public class TVshowDriver extends Configured implements Tool {

	public static void main(String[] args) throws Exception {
		ToolRunner.run(new TVshowDriver(), args);
	}

	@Override
	public int run(String[] args) throws Exception {
		Configuration conf = getConf();
		conf.setStrings("StrName", "testing");
		
		Job job = new Job(conf,"TVShow Counts");
		job.setJarByClass(TVshowDriver.class);
		
		job.setMapperClass(TVshowMapper.class);
		job.setReducerClass(TVshowReducer.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		//one for <TV show, count> and other reducer for <TV show title, channel>
		job.setNumReduceTasks(2);
		job.setPartitionerClass(TVshowPartitioner.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
		
		return 0;
	}

}
