package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HelloWorld implements Serializable {

	/**
	 * @param args
	 */
	String helloTxt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Sri");
		HelloWorld hw = new HelloWorld();
		hw.setTxt();
		serializeThisObj(hw);
	}
	
	static void serializeThisObj(HelloWorld hwObj){
		String filename = "C://test//hello.ser";
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(hwObj);
            out.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
	}
	
	void setTxt(){
		helloTxt = new String("hello from print method");
		System.out.println("hello from print method");
	}

}
