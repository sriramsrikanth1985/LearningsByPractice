package collections.Set;

import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String args[]){
		TreeSet<String> lhs = new TreeSet<String>();
		lhs.add("sri");
		lhs.add("hello");
		lhs.add("abc");
		System.out.println(lhs.toString()); //Always ordered
		lhs.add("bcd");
		System.out.println(lhs.toString()); //Sorted 
		System.out.println(lhs.size());
		System.out.println(lhs.isEmpty());
		System.out.println(lhs.getClass());
		lhs.remove("bcd");
		System.out.println(lhs.toString()); //Sorted
		
	}
}
