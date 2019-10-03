package com.felix.hadoop.training;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCoOccurenceMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	/**
	 * An optimization technique, instead of creating the variable everytime in the map function
	 * create once here and set inside the map function
	 */

	private Text key = new Text();
	private IntWritable one = new IntWritable(1);

	@Override
	public void map(LongWritable inputKey,Text inputVal,Context context) throws IOException,InterruptedException
	{
		String line = inputVal.toString();
		String[] splits = line.trim().split("\\W+");
		//here we are not considering if the lines consist of single word only

		for(int i=0;i<splits.length-1;i++)
		{
			key.set(splits[i] +":"+splits[i+1]);
			context.write(key, one);
		}



	}

}
