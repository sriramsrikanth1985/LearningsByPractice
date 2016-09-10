package intellipaat;

/**
 * 
 * @author ssriram
 * 
 * Inner classes are a security mechanism in Java. 
 * We know a class cannot be associated with the access modifier private, but if we define a class as a member of other class, then the inner class can be made private. 
 * And this is also used to access the private members of a class.
 * 
 * InnerClasses Example
 * 1. Static Inner Class
 * 2. Non-Static Innner Class
 * 	2.a) Member Inner Class
 * 	2.b) Local Inner Class
 *	2.c) Anonymous Inner Class
 */

public class InnerClassExample {
	
	private static int staticPrivateInt = 12;
	private int privateInt = 14;
	
	//1. Static inner class example
	private static class staticInnerClass {
		static void printStaticStr(){
			System.out.println("Hello from Static InnerClass and can access static members of outer class: "+staticPrivateInt);
			System.out.println("Hello from Static InnerClass and can access non-static members of outer class: "+new InnerClassExample().privateInt);
		}
	}
	
	//2.a Non-Static Member Class type --> Inside the class another class is defined
	class nonStaticInnerClass {
		void printNonStaticStr(){
			System.out.println("Hello from Non-Static Member InnerClass and can access static members of outer class: "+staticPrivateInt);
			System.out.println("Hello from Non-Static Member InnerClass and can access non-static members of outer class: "+privateInt);
		}
	}
	
	//2.b Local Inner Class --> Inside method a class is defined
	void printInfo() {
		class LocalInnerClass {
			void printNonStaticLocalInnerClass(){
				System.out.println("Hello from Non-Static Local InnerClass and can access static members of outer class: "+staticPrivateInt);
				System.out.println("Hello from Non-Static Local InnerClass and can access non-static members of outer class: "+privateInt);
			}
		}
		
		LocalInnerClass lic = new LocalInnerClass();
		lic.printNonStaticLocalInnerClass();
	}
	
	public static void main(String args[]){
		
		//1. Static Class --> without object we can call this static inner class as below:
		InnerClassExample.staticInnerClass.printStaticStr();
		
		//2.a Creating an instance of Member InnerClass
		InnerClassExample.nonStaticInnerClass innerClass = (new InnerClassExample()).new nonStaticInnerClass();
		innerClass.printNonStaticStr();
		
		//2.b Local Inner Class
		InnerClassExample ice = new InnerClassExample();
		ice.printInfo();
		
		//2.c Creating an anonymous inner class for interface
		testIntf t = new testIntf() {
			@Override
			public void printStrNonStaticAnonymousInnerClassForInterface() {
				System.out.println("Hello from Anonymous Inner class for inteface "+this.num);
				System.out.println("Hello from Non-Static Anonymous InnerClass (interface) and can access static members of outer class: "+staticPrivateInt);
				System.out.println("Hello from Non-Static Anonymous InnerClass (interface) and can access non-static members of outer class: "+new InnerClassExample().privateInt);
			}
		};
		t.printStrNonStaticAnonymousInnerClassForInterface();
		
		//2.c Creating an anonymous inner class for abstract
		testAbs tA = new testAbs() {
		};
		System.out.println("numFromAbstract: "+tA.numFromAbstract); //200
		tA.printStrNonStaticAnonymousInnerClassForAbstract();
		System.out.println("numFromAbstract after method call: "+tA.numFromAbstract); //150
	}
}

interface testIntf {
	int num = 100;
	void printStrNonStaticAnonymousInnerClassForInterface();
}

abstract class testAbs {
	int numFromAbstract = 200;
	void printStrNonStaticAnonymousInnerClassForAbstract(){
		this.numFromAbstract = 150;
		System.out.println("Hello from Anonymous Inner class for Abstract: "+numFromAbstract);
	}
}
