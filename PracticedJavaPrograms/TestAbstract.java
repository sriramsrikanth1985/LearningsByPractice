
public class TestAbstract {
	public final String ab;
	
	public TestAbstract() {
		ab = "sri";
	}

	public void getThings(){
		
	}

	public String abc;
	
	public static void main(String args[]){
		TestAbstract ta = new TestAbstract();
		try {
			int x=1;
			System.out.println("calling finalize method"+x);
			ta.finalize();
			System.out.println("called finalized method");
			
			ta.hello();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void hello(){
		System.out.println(abc);
	}
	
	protected void finalize() {
		System.out.println("In finalize method");
	}
	
	


}
