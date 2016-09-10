package junitExample;

import java.text.SimpleDateFormat;
import java.util.Date;


public class testParsingDate {


	String datest = "Monday, December 13, 2010 14:10:32 UTC"; 
	SimpleDateFormat formatter = new SimpleDateFormat("EEEEE, MMMMM dd, yyyy HH:mm:ss Z"); 
	//Date dt = formatter.parse(datest);
	
	//formatter.applyPattern("dd-MM-yyyy"); 
	//String dtstr = formatter.format(dt); 
	//assertEquals("should be 13-12-2010", "13-12-2010", dtstr); 

}