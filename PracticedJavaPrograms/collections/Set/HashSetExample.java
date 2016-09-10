package collections.Set;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetExample {
	public static void main(String args[]){
		HashSet<String> hs = new HashSet<String>();
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("hello1");
		al.add("hello");
		al.add("hello2");
		
		
		hs.add("sri");
		hs.add("kanth");
		hs.add("sri"); //Cannt have duplicates hence not added
		hs.add("hello");
		hs.addAll(al);
		System.out.println(hs.toString());
	}
}
