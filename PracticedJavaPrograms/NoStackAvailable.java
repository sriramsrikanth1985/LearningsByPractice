import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;


public class NoStackAvailable extends Thread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int cnt=0;
		
		while(true) {
			(new Thread(new NoStackAvailable())).start();
			
			cnt++;
			System.out.println("object created: "+cnt);
		}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
