package treeMapImpl;

import java.util.TreeMap;

public class Demo2 {

	 public static void main(String[] args) {
	  TreeMap<Person, String> map = new TreeMap<Person, String>();
	  Person p1 = new Person(18);
	  Person p2 = new Person(6);
	  Person p3 = new Person(4);
	  Person p4 = new Person(12);
	  Person p5 = new Person(10);
	  map.put(p1, "first data");
	  map.put(p2, "second data");
	  map.put(p3, "third data");
	  map.put(p4, "fourth data");
	  map.put(p5, "fifth data");
	  System.out.println(map);
	 }
}
