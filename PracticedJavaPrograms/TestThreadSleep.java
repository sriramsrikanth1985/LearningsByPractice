import java.util.Date;


public class TestThreadSleep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("before the thread sleep: "+new Date()+"id: "+Thread.currentThread().getId());
		try {
			//Thread.sleep(2*60*1000);
			//Thread.currentThread().wait();
		       	 int count = 100000000;
		       	 do{
		       		 count--;
		       		 System.out.println("cnt: "+count);
		       	 }while(count > 0);
		 System.out.println("after the thread sleep: "+new Date());
			//Thread.currentThread().sleep(50000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
