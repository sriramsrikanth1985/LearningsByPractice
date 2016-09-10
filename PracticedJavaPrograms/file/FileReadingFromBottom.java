package file;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.logging.FileHandler;

import com.mysql.jdbc.Buffer;

public class FileReadingFromBottom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

/*			FileInputStream f = new FileInputStream("C:\\test\\testing.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(f));
			String line = null;
			while( (line = br.readLine()) != null)
				System.out.println(line);
			
			System.out.println();
			
			String line1 = null;
			FileReader fr = new FileReader("C:\\test\\testing.txt");
			BufferedReader br1 = new BufferedReader(fr);
			while( (line1 = br1.readLine()) != null)
				System.out.println(line1);*/
			
			try {
				ReverseFileReader rfr = new ReverseFileReader(new File("C:\\test\\testing.txt"));
				String line = null;
				while( (line = rfr.readLine()) != null)
					System.out.println(line);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

}
