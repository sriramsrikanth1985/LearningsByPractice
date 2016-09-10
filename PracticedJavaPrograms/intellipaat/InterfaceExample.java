package intellipaat;

public class InterfaceExample {
	public static void main(String args[]){
		///we can have interface reference to point to its implementation class object as below:
		//batteries, batteriesNew are the interface
		//a class implements both above interfaces, hence it has to implement all the methods of both interfaces
		//b calsss implements only batteries interface, hence only one method it implements
		batteries bat = new a();
		bat.printHello();
		
		//The below is not possible, because bat doesnt have printHelloWorld method
		//bat.printHelloWorld();
		
		batteriesNew batNew = new a();
		batNew.printHelloWorld();
		batNew.printHello();
		
		bat = new b();
		bat.printHello();
		
	}
}

interface batteries {
	int intA = 10;
	void printHello();
}

interface batteriesNew extends batteries{
	int intA = 10;
	void printHelloWorld();
}

class a implements batteries, batteriesNew {
	public void printHello() {
		System.out.println("Hello from a's class");
	}
	
	public void printHelloWorld() {
		System.out.println("HelloWorld from a's class");
	}
}

class b implements batteries {
	public void printHello() {
		System.out.println("Hello from b's class");
	}
}
