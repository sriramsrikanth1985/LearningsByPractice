package synchronization;

import java.util.Date;

public class Test extends Thread {
	
	private Thread t;
	public static int count = 0;
	
	public Test(){
		
		count++;
		System.out.println("Creating "+Thread.currentThread().getName() + " object count: "+count);
	}
	
	   public void start ()
	   {
	      System.out.println("Starting " +  Thread.currentThread().getName() );
	   }
	   
	   public void run() {
		   System.out.println("Running " +  Thread.currentThread().getName() );
		   this.printAndSleep();
	   }
	
	public static synchronized void printAndSleep(){
		try {
			System.out.println("current Time before 10 mins sleep"+new Date() + " by thread: "+Thread.currentThread().getName());
			Thread.sleep(10000);
			System.out.println("current Time after  10 mins sleep"+new Date() + " by thread: "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
