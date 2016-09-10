package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadFromSerializeObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String filename = "C://test//hello.ser";
        FileInputStream fos = null;
        ObjectInputStream in = null;
        try{
            fos = new FileInputStream(filename);
            in = new ObjectInputStream(fos);
            //System.out.println(in.readLine());
            try {
				HelloWorld hwNew = (HelloWorld) in.readObject();
				System.out.println(hwNew.helloTxt);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            in.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
	}

}
