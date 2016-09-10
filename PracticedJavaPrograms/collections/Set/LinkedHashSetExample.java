package collections.Set;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
	public static void main(String args[]){
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.add("sri");
		lhs.add("hello");
		lhs.add("abc");
		System.out.println(lhs.toString());
		lhs.add("bcd");
		System.out.println(lhs.toString());
		System.out.println(lhs.size());
		System.out.println(lhs.isEmpty());
		System.out.println(lhs.getClass());
	}
}
