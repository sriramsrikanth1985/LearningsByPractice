
//import objectexplorer.ObjectGraphMeasurer;

public class Measurer {

  public static void main(String[] args) {
/*    Set<Integer> hashset = new HashSet<Integer>();
    Random rng = new Random();
    int n = 10000;
    for (int i = 1; i <= n; i++) {
      hashset.add(random.nextInt());
    }
    System.out.println(ObjectGraphMeasurer.measure(hashset));*/

	  
	  Runtime.getRuntime().gc();
	  
	  long before = Runtime.getRuntime().totalMemory();
	  long heapMaxSize = Runtime.getRuntime().maxMemory();
	  long heapFreeSize = Runtime.getRuntime().freeMemory();
	  
	  System.out.println("Before: "+before +" heapMax: "+heapMaxSize + " heapFree: "+heapFreeSize );
	  String str = new String("srikanth");
	  Measurer mr = new Measurer();
	  Measurer mr1 = new Measurer();
	  Measurer mr2 = new Measurer();
	  Measurer mr3 = new Measurer();
	  Measurer mr4 = new Measurer();
	  Measurer mr5 = new Measurer();
	  //Runtime.getRuntime().gc();
	  
	  long after = Runtime.getRuntime().totalMemory();
	  long afterheapMaxSize = Runtime.getRuntime().maxMemory();
	  long afterheapFreeSize = Runtime.getRuntime().freeMemory();
	  System.out.println("After: "+after +" heapMax: "+afterheapMaxSize + " heapFree: "+afterheapFreeSize );
	  
	  System.out.println("Total size: "+(heapFreeSize-afterheapFreeSize));
  }
}
