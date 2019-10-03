package com.hadoop.tvshows;

import java.io.IOException;
import java.util.StringTokenizer;
//import java.util.logging.Logger;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TVshowMapper extends Mapper<LongWritable, Text, Text, Text> {

	
/*	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		System.out.println("inside TVshowMapper setup() method END !!!");
	}*/
	
	@Override
	protected void map(LongWritable key, Text val, Context context) throws IOException, InterruptedException {

		String str = val.toString();
		if(str != null){
			StringTokenizer st = new StringTokenizer(str, ",");
			
			if(st.hasMoreTokens()){
				String tvshow = st.nextToken();
				String channelOrViewsCnt = st.nextToken();				
				context.write(new Text(tvshow), new Text(channelOrViewsCnt));
			}
		}
		
	}
	
/*	@Override
	protected void cleanup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		System.out.println("Exit from cleanup method of Mapper");
	}*/


}

