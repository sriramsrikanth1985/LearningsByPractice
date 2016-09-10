
class A1 {
	
	private A1(){
		System.out.println("Inside A1 constructor");
	}
	
	public A1(int a){
		System.out.println("Inside A1 constructor: " +a);
	}
	
	public void eat() throws Exception {
		// throws an Exception
		System.out.println("inside eat method of A1");
		}
	
	public static void main(String args[]){
		A1 a = new A1();
		try {
			a.eat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
