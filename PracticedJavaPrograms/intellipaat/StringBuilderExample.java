package intellipaat;

/**
 * 
 * @author ssriram
 * StringBuilder class object contents can be modified or extended (without creating a new object) unlike..
 * String class object where it will create a new object for each change to it.
 */

public class StringBuilderExample {
	public static void main(String args[]){
		
		Runtime rt = Runtime.getRuntime();
		rt.gc();
		System.out.println("Total memory: "+rt.totalMemory()/(1024*1024));
		System.out.println("Free memory: "+rt.freeMemory()/(1024*1024));
		System.out.println("Used memory: "+(rt.totalMemory()-rt.freeMemory())/(1024*1024));
		
		StringBuilder sb = new StringBuilder();
		sb = new StringBuilder("Hello");
		System.out.println("length: "+sb.length());
		System.out.println("capacity: "+sb.capacity());
		
		for(int i=0;i<50000;i++)
			sb.append("Hi");
		
		System.out.println("length: "+sb.length());
		System.out.println("capacity: "+sb.capacity());

		System.out.println("Total memory after: "+rt.totalMemory()/(1024*1024));
		System.out.println("Free memory after: "+rt.freeMemory()/(1024*1024));
		System.out.println("Used memory after: "+(rt.totalMemory()-rt.freeMemory())/(1024*1024));
	}
}
