package intellipaat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.sun.javafx.fxml.builder.URLBuilder;

public class URLTesting {
	
	public static void main(String args[]){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inputStr = br.readLine();
			System.out.println(inputStr);
			URL url = new URL(inputStr);
			BufferedReader outputStr = new BufferedReader(new InputStreamReader(url.openStream()));
			System.out.println(outputStr.readLine());
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			//System.out.println("inside IOException");
			//e.printStackTrace();
			System.out.println(e.getClass());
			System.out.println("hi"+e.getMessage());
		}catch(Exception e){
			System.out.println("hello");
			System.err.println(e.getMessage());
		}
	}

}
