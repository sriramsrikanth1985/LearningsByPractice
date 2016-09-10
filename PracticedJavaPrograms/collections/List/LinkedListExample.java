package collections.List;

import java.util.LinkedList;

public class LinkedListExample {
	public static void main(String args[]){
		LinkedList<String> ll = new LinkedList<String>(); //ordered collection
		ll.add("sri");
		ll.add("kanth");
		ll.add(1, "hello");
		ll.add("sri"); //List can have duplicates
		ll.removeLast();
		System.out.println(ll.toString());
	}
}
