package synchronization;

import decoratorDesignPatter.*;

public class ThreadDemo extends Girl {

	public static void main(String args[]){
		Thread t1 = new Thread(new Test());
		Thread t2 = new Thread(new Test());
		Test t = new Test();
		Thread t3 = new Thread(new Test());

		t1.start();
		t2.start();
		t3.start();
		
		
		
		
	}
}
