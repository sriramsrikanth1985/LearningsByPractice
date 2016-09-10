package intellipaat;

/**
 * 
 * @author ssriram
 * 
 */

public class ThreadsExample {
	public static void main(String args[]){
		// creating an instance of ThreadExtends class
				ThreadExtends te = new ThreadExtends();  //With this the Thread will be in New State
				//Starting the thread to run
				te.run(); //With this, the Thread will be in Runnable State
				//This state will be in Runnable state itself, until scheduler actually starts execution, then state will be moved to Running State
				
				try {
					//during running state, if sleep encountered, then it will be moved to Sleep/Waiting/Blocked state
					te.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		//Creating an instance of ThreadRunnable class
				ThreadRunnable tr = new ThreadRunnable();
				Thread t = new Thread(tr);
				t.start();
	}

}

class ThreadExtends extends Thread {
	//System.out.println("Hello from ThreadRunnable example");
	public void run(){
		System.out.println("Hello from ThreadExtends class");
	}
}

class ThreadRunnable implements Runnable {
	public void run(){
		System.out.println("Hello from ThreadRunnable example");
	}
}
