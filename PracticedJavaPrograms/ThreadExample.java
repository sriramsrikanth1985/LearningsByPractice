
public class ThreadExample {
	public static void main(String args[]){
		Thread t1 = new ThreadExampleExtn();
		Thread t2 = new ThreadExampleExtn();
		//t1.start(); //start will create a new thread and calls run method
		//t2.start();
		t1.run(); // run will only call the run method from the current thread
		//t2.run();
	}
}


