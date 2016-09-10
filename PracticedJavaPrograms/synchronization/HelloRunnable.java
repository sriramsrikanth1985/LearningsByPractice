package synchronization;

import java.util.Date;

public class HelloRunnable implements Runnable {
	private static int count;
	public HelloRunnable() {
		// TODO Auto-generated constructor stub
		count++;
		System.out.println(count);
	}


    public void run() {
        System.out.println("Hello from a thread!"+Thread.currentThread().getName());
        this.printAndSleep();
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
        (new Thread(new HelloRunnable())).start();
        (new Thread(new HelloRunnable())).start();
        (new Thread(new HelloRunnable())).start();
    }
    
    
	
	public  static synchronized void printAndSleep(){
		try {
			System.out.println("current Time before 10 secs sleep"+new Date() + " by thread: "+Thread.currentThread().getName());
			Thread.sleep(10000);
			System.out.println("current Time after  10 secs sleep"+new Date() + " by thread: "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}