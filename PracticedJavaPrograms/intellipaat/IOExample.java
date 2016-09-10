package intellipaat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOExample {
	
	public static void main(String args[]){
		
		//bytesStream();
		//charStream();
		//serializationExample();
		channelDemo();
	}
	
	static void channelDemo(){
		try {
			FileInputStream in = new FileInputStream("C:\\Ddrive\\Eclipse_Workspace\\testing\\src\\intellipaat\\test.dat");
			FileOutputStream out = new FileOutputStream("C:\\Ddrive\\Eclipse_Workspace\\testing\\src\\intellipaat\\test.outChannel");
			
			FileChannel inChannel = in.getChannel();
			FileChannel outChannel = out.getChannel();
			
			int buffSize = 2048;
			ByteBuffer bb = ByteBuffer.allocate(buffSize);
			long startTime = System.nanoTime();
			while(inChannel.read(bb) > 0){
				bb.flip();
				outChannel.write(bb);
				bb.clear();
			}
			System.out.println("Time taken: "+(System.nanoTime()-startTime));
			inChannel.close();outChannel.close();in.close();out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void bytesStream(){
		try {
			int i;
			InputStream in = new FileInputStream("C:\\Ddrive\\Eclipse_Workspace\\testing\\src\\intellipaat\\test.dat");
			OutputStream out = new FileOutputStream("C:\\Ddrive\\Eclipse_Workspace\\testing\\src\\intellipaat\\test.out");
			while((i=in.read())!=-1){
				System.out.print((char)i);
				out.write(i);
			}
			in.close();out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void charStream(){
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Ddrive\\Eclipse_Workspace\\testing\\src\\intellipaat\\test.dat"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Ddrive\\Eclipse_Workspace\\testing\\src\\intellipaat\\test.out1"));
			String str;
			while( (str=br.readLine()) != null){
				System.out.println(str);
				bw.write(str);
				bw.newLine();
			}
			br.close();bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void serializationExample(){
		Employee emp = new Employee("Sri", 1);
		try {
			ObjectOutputStream objOuput = new ObjectOutputStream(new FileOutputStream("C:\\Ddrive\\Eclipse_Workspace\\testing\\src\\intellipaat\\test.serialized"));
			objOuput.writeObject(emp);
			
			ObjectInputStream objInput = new ObjectInputStream(new FileInputStream("C:\\Ddrive\\Eclipse_Workspace\\testing\\src\\intellipaat\\test.serialized"));
			Employee emp1 = (Employee)objInput.readObject();
			System.out.println(emp1);
			
			objOuput.close();objInput.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Employee implements Serializable{
	String name;
	int id;
	Employee(String name,int id){
		this.name= name;
		this.id=id;
	}
	public String toString(){
		return "The Employee Name: "+this.name+"  and id: "+this.id;
	}
}