package testing;

public class SystemClass {
	public static void main(String args[]){
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.vendor"));
		System.setProperty("java.vendor1", "Oracle");
		System.out.println(System.getProperty("java.vendor1"));
		
		Runtime rt = Runtime.getRuntime();
		System.out.println("Total memory: "+rt.totalMemory()/(1024*1024));
		System.out.println("Free memory: "+rt.freeMemory()/(1024*1024));
		System.out.println("Used memory: "+(rt.totalMemory()-rt.freeMemory())/(1024*1024));
		
		String str = new String("Hello");
		for(int i=0;i<50000;i++){
			str = str+"Hi";
		}
		
		System.out.println("Total memory after: "+rt.totalMemory()/(1024*1024));
		System.out.println("Free memory after: "+rt.freeMemory()/(1024*1024));
		System.out.println("Used memory after: "+(rt.totalMemory()-rt.freeMemory())/(1024*1024));
		
		rt.gc();
		
		System.out.println("Total memory after gc: "+rt.totalMemory()/(1024*1024));
		System.out.println("Free memory after gc: "+rt.freeMemory()/(1024*1024));
		System.out.println("Used memory after gc: "+(rt.totalMemory()-rt.freeMemory())/(1024*1024));
	}
}
