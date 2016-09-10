package recursive;

public class RecursivCountIncrForStackOverFlow {
	
	int num= 0;
	
	public void incrNum(){
		Runtime rt = Runtime.getRuntime();
		try{
			while(num<20000){
				System.out.println(num);
				System.out.println((rt.freeMemory() / (1024*1024) ));
				num++;
				incrNum();
			}
		} catch(StackOverflowError e){
			System.out.println("num: "+num);
			//System.out.println(e.getMessage());

			System.out.println((rt.freeMemory() / (1024*1024) ) + "/" + (rt.maxMemory() / (1024*1024*1024)) + " gB");
			System.out.println((rt.totalMemory() / (1024*1024) ) + " gB");
			System.exit(0);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Runtime rt = Runtime.getRuntime();
			System.out.println((rt.freeMemory() / (1024*1024) ) + "/" + (rt.maxMemory() / (1024*1024*1024)) + " gB");
			System.out.println((rt.totalMemory() / (1024*1024) ) + " gB");
			
			RecursivCountIncrForStackOverFlow rc = new RecursivCountIncrForStackOverFlow();
			rc.incrNum();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
