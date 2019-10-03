package com.felix.hadoop.training;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class WordCoOccurenceReducer extends Reducer<Text,IntWritable,Text, IntWritable>{
	/**
	 * An optimization technique, instead of creating the variable everytime in the reduce function
	 * create once here and set inside the reduce function
	 */
	private IntWritable finalSum = new IntWritable();

	@Override
	public void reduce(Text key,Iterable<IntWritable> listOfValues,Context context) throws IOException,InterruptedException
	{
		int sum=0;
		for(IntWritable val:listOfValues)
		{
			sum = sum + val.get();
		}
		finalSum.set(sum);
		context.write(key,finalSum);


	}

}