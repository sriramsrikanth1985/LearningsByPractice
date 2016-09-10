package superSubClasses;

public class B extends A {
	int a;
	public B(int b, String ab) {
		super(b, ab);
		System.out.println("inside B constructor with two arguments: "+b+" and other: "+ab);
	}
	public B(){
		super(10);
		System.out.println("inside B constructor with no arguments");
	}
	
	
	public static void print() {
		
	}
	
	public static void main(String args[]){
		new B().print();
	}
}
