package com.hadoop.tvshows;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TVshowReducer extends Reducer<Text, Text, Text, Text> {
	
/*	@Override
	protected void setup(Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
	}*/
	
	
	@Override
	protected void reduce(Text tvshow, Iterable<Text> channelOrViewsCnt, Context context) throws IOException, InterruptedException {
		
		//Boolean for identifying viewCounts or channelName
		Boolean IsViewCounts = false;
		Integer totalViews = 0;
		
		Iterator<Text> itr = channelOrViewsCnt.iterator();
		try {
			Text channelOrView = itr.next();
			Integer.parseInt(channelOrView.toString());
			IsViewCounts = true;
		} catch (NumberFormatException ne){
			//nothing to do, since anyway IsViewCounts is default to false
		}
		
	
		if(IsViewCounts) {
			for(Text views:channelOrViewsCnt){
				totalViews = totalViews+Integer.parseInt(views.toString());
			}
			context.write(tvshow, new Text(totalViews.toString()));
			
		} else {
			for(Text channel:channelOrViewsCnt){
				context.write(tvshow, channel);
			}
		}
	}
	

/*	@Override
	protected void cleanup(Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
	}*/

}
