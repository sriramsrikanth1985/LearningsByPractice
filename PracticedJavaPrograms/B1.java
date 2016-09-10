
public class B1 extends A1  {
	
	public void eat() { // no Exceptions 
		System.out.println("Inside eat method of B1 class");
	}
	
	public void eatNew() { // no Exceptions 
		System.out.println("Inside eatNew method of B1 class");
	}
	
	public B1(){
		super(2);
		System.out.println("Inside B1 constructor");
	}
		public static void main(String [] args) {
		A1 a = new A1(4);
		B1 d = new B1();
		A1 a1 = new B1();
		//d.eat(); // ok
		try {
			a1.eat();
			//a1.eatNew();
			d.eatNew();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // compiler error -
		// unreported exception
		}

}
