class Cat {
	public  void print() {
		System.out.println("Inside Cat");
	}
}

class Machin extends Cat {
	public void print() {
		System.out.println("Inside Machin");
	}
}

public class StaticMethodsOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat c = new Cat();
		c.print();
		Machin m = new Machin();
		m.print();
		
		(new StaticMethodsOverriding()).test(null);

	}
	
	void test(Cat c){
		System.out.println("inside cat");
	}
	
	void test(Machin c){
		System.out.println("inside machin");
	}
	
	void test(Object obj){
		System.out.println("inside obj");
	}
}
