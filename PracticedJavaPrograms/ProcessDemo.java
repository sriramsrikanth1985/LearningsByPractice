import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProcessDemo {


    	  public static void main(String [] args) throws IOException {
    	        
    	        String[] command = {"CMD", "/C", "dir"};
    	        ProcessBuilder probuilder = new ProcessBuilder( command );

    	        //You can set up your work directory
    	        probuilder.directory(new File("C:\\Windows\\Temp"));
    	        
    	        Process process = probuilder.start();
    	        
    	        //Read out dir output
    	        InputStream is = process.getInputStream();
    	        InputStreamReader isr = new InputStreamReader(is);
    	        BufferedReader br = new BufferedReader(isr);
    	        String line;
    	        StringBuffer sb = new StringBuffer();
    	        System.out.printf("Output of running %s is:\n",
    	                Arrays.toString(command));
    	        while ((line = br.readLine()) != null) {
    	            System.out.println(line);
    	            sb.append(line);
    	            sb.append("\n");
    	        }
    	        
    	        //Wait to get exit value
    	        try {
    	            int exitValue = process.waitFor();
    	            System.out.println("\n\nExit Value is " + exitValue);
    	            
    	            System.out.println("Contents of sb: "+sb);
    	            
    	        } catch (InterruptedException e) {
    	            // TODO Auto-generated catch block
    	            e.printStackTrace();
    	        }
    	    }

}
