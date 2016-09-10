package intellipaat;

/**
 * 
 * @author ssriram
 * Public --> It should be accessicible from anywhere, since JVM accesses this main method from outside
 * static --> JVM would not be creating an object to invoke main method, hence static
 * void --> it returns nothing to the JVM once invoked this main method
 * main --> Main method is the starting point of execution to the JVM when this class is loaded
 */

public class PublicVoidMainExample {
	public static void main(String args[]){
		System.out.println("Hello World !!!");
	}

}

