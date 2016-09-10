package thread.multiThread;

public class DeadLockEx /*implements Runnable*/ extends Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new DeadLockEx());
		Thread t2 = new Thread(new DeadLockEx());
		Thread t3 = new Thread(new DeadLockEx());
		System.out.println("hello before the start of the threads");

		t1.start();
		t2.start();
		t3.start();
	}
	
	public void method1(){
		synchronized(String.class){
		System.out.println(Thread.currentThread().getName()+"  method1 -- Aquired lock on String.class object");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (Integer.class) {
		System.out.println(Thread.currentThread().getName()+"  method1 -- Aquired lock on Integer.class object");
		}
		}
		}

		public void method2(){
		synchronized(Integer.class){
		System.out.println(Thread.currentThread().getName()+"  mehod2 -- Aquired lock on Integer.class object");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (String.class) {
		System.out.println(Thread.currentThread().getName()+"  method2 -- Aquired lock on String.class object");
		}
		}
		}

		public void run() {
			// TODO Auto-generated method stub
			System.out.println("hello");
			//DeadLockEx d1 = new DeadLockEx();
			this.method1();
			this.method2();
		}

}
