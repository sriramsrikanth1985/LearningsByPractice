package thread.sleep;

import java.util.Date;

public class ThreadSleep {
	public static void main(String args[]){
		System.out.println("hello: "+new Date());
		try{
//			new Thread("hello");
			new Thread().sleep(5000);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("back: "+new Date());
	}
}
