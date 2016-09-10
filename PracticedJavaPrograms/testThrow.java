public class testThrow {
	public static void main(String args[]){
		testThrow t = new testThrow();
		try{
			t.testMethod();
			System.out.println("After testMethod");
		}catch(Exception e){
			System.out.println("Exception caught in Main method"+e.getStackTrace());
		}

	}
	
	void testMethod() throws Exception {
		try{
			System.out.println("printing try1");
			int k=5/0;
			//String abc = null;
			//System.out.println(abc.toString());
		} catch(Exception e){
			System.out.println("Inside Exception:"+e.getMessage());
			//System.out.println("Inside Exception Stack Trace:"+e.getStackTrace());
			throw e;
		} finally {
			System.out.println("Inside finally");
		}
	}

}

