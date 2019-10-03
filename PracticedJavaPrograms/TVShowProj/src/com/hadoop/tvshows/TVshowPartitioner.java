package com.hadoop.tvshows;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class TVshowPartitioner extends Partitioner<Text,Text>{
    public int getPartition(Text tvshow, Text channelOrViewsCnt, int numReduceTasks){
		//here, partition is used to identify the input type (viewCounts or ChannelName) and according write separate files
		try {
			//If integer, then its view count of the tvshow
			Integer.parseInt(channelOrViewsCnt.toString());
			return 0;
		} catch (NumberFormatException ne) {
			//If not integer, then its the channelName of the tvshow
			return 1;
		}
    }
}
