package intellipaat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 * @author ssriram
 * List: ArrayList, LinkedList
 * Set: HashSet, LinkedHashSet, TreeSet
 * Map: HashMap, HashTable, LinkedHashMap, TreeMap
 * Queue: LinkedList, PriorityQueue
 */
public class CollectionsExample {
	public static void main(String args[]){
		//arrayListTesting();
		//linkedListTesting();
		
		
		//hashSetExample();
		//linkedHashSetExample();
		//treeSetExample();
		
		//hashMapExample();
		treeMapExample();
	}
	
	/**
	 * 
	 * Insertion/Deletion of elements needs shifting of any subsequent elements at the right (i.e, subtracts/add one to their indices of right elements).
	 * Hence, Insertion/Deletion is time taking or slow.
	 * 	ArrayList has direct references to every element in the list, so it can get the n-th element in constant time. 
	 * 	LinkedList has to traverse the list from the beginning to get to the n-th element.
	 */
	static void arrayListTesting(){
		//ArrayList
		List l = new ArrayList();
		System.out.println("1. ArrayList: "+l);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add("hello");
		System.out.println("2. ArrayList: "+l); //[1,2,3]
		l.remove(1); //remove at index 1
		l.remove("hello"); //remove the object "hello"
		l.add(2); //Always adds at the end
		System.out.println("3. ArrayList: "+l); //[1,3,2]
		l.add(1, 4);
		l.add(3); //Allows duplicate to be stored
		System.out.println("4. ArrayList: "+l); //[1,4,3,2,3]
		
		System.out.println("printing ArrayList via iterator");
		Iterator itr = l.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		ListIterator itr1 = l.listIterator();
		while(itr1.hasNext())
			itr1.next();
		System.out.println("printing ArrayList in reverse direction");
		while(itr1.hasPrevious())
			System.out.println(itr1.previous());
	}
	
	//From here List usage

	/**
	 * Insertion/Deletion are fast, because no need to shift all the elements (to the right) after adding an element in middle of linked list
	 * Searching will take time
	 */
	static void linkedListTesting(){
		//ArrayList
		LinkedList l = new LinkedList();
		System.out.println("1. LinkedList: "+l);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add("hello");
		System.out.println("2. LinkedList: "+l); //[1,2,3]
		l.remove(1); //remove at index 1
		l.remove("hello"); //remove the object "hello"
		l.add(2); //Always adds at the end
		System.out.println("3. LinkedList: "+l); //[1,3,2]
		l.add(1, 4);
		l.add(3); //Allows duplicate to be stored
		System.out.println("4. LinkedList: "+l); //[1,4,3,2,3]
		//Adding at first
		l.addFirst(8); //push operation
		System.out.println("5. LinkedList: "+l);
		//Removing first
		l.removeFirst(); //pop operation
		System.out.println("6. LinkedList: "+l);
		
		
		System.out.println("printing LinkedList via iterator");
		Iterator itr = l.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		ListIterator itr1 = l.listIterator();
		while(itr1.hasNext())
			itr1.next();
		System.out.println("printing LinkedList in reverse direction");
		while(itr1.hasPrevious())
			System.out.println(itr1.previous());
	}
	
	/**
	 * Desnt maintain the insertion order, it will get sorted
	 */
	static void hashSetExample(){
		HashSet l = new HashSet();
		System.out.println("1. HashSet: "+l);
		l.add(1);
		l.add(2);
		System.out.println("1. HashSet between: "+l);
		l.add(3);
		l.add("hello");
		System.out.println("2. HashSet: "+l); 
		l.remove(1); //remove object 1
		l.remove("hello"); //remove the object "hello"
		l.add(4); //Always adds at the end
		l.add("hi");
		l.add(8);
		System.out.println("3. HashSet: "+l); 
		//l.add(1, 4); --> this is not possible to add at index since no index is maintained
		l.add(3); //no change in the set, since already 3 exists
		System.out.println("4. HashSet: "+l); 
		
		Iterator itr = l.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());

	}
	
	//From here Set usage
	
	/**
	 * Always adds the new element at the end of the Set ==> it maintains the insertion order
	 */
	static void linkedHashSetExample(){
		Set l = new LinkedHashSet();
		System.out.println("1. LinkedHashSet: "+l);
		l.add(1);
		l.add(2);
		System.out.println("1. LinkedHashSet between: "+l);
		l.add(3);
		l.add("hello");
		System.out.println("2. LinkedHashSet: "+l); 
		l.remove(1); //remove object 1
		l.remove("hello"); //remove the object "hello"
		l.add(4); //Always adds at the end
		l.add("hi");
		l.add(8);
		System.out.println("3. LinkedHashSet: "+l); 
		//l.add(1, 4);  --> this is not possible to add at index since no index is maintained
		l.add(3); //no change in the set, since already 3 exists
		System.out.println("4. LinkedHashSet: "+l); 
		
		Iterator itr = l.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());

	}
	
	/**
	 * Objects are stored in sorted, ascending order.
	 * Access and retrieval times are quite fast, which makes TreeSet an excellent choice when storing large amounts of sorted information that must be found quickly.
	 */
	static void treeSetExample(){   
	      
		TreeSet l = new TreeSet();
		System.out.println("1. TreeSet: "+l);
		l.add("1");
		l.add("2");
		l.add("4");
		System.out.println("1. TreeSet between: "+l);
		l.add("3");
		l.add("hello");
		System.out.println("2. TreeSet: "+l); 
		l.remove("1"); //remove object 1
		l.remove("hello"); //remove the object "hello"
		l.add("4"); //Always adds in sorted order
		l.add("hi");
		l.add("8");
		System.out.println("3. TreeSet: "+l); 
		//l.add(1, 4); --> this is not possible to add at index since no index is maintained
		l.add("3"); //no change in the set, since already 3 exists
		System.out.println("4. TreeSet: "+l); 
		
		Iterator itr = l.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
	
	static void hashMapExample(){
		Map l = new HashMap();
		
		System.out.println("1. HashMap: "+l);
		l.put(1, "1");
		l.put(2, "2");
		l.put(3, "4");
		System.out.println("1. HashMap between: "+l);
		l.put(4, "3");
		l.put(5,"hello");
		System.out.println("2. HashMap: "+l); 
		l.remove(1); //remove object key 1
		l.remove(5,"hello"); //remove the object key 5 and value "hello"
		l.put(6,"4"); //Always adds in sorted order
		l.put(7,"hi");
		l.put(8,"8");
		System.out.println("3. HashMap: "+l); 
		//l.add(1, 4); --> this is not possible to add at index since no index is maintained
		l.put(9,"3"); //no change in the set, since already 3 exists
		System.out.println("4. HashMap: "+l); 
		
		Iterator itr = l.keySet().iterator();
		while(itr.hasNext())
			System.out.println(l.get(itr.next()));
	}
	
	static void treeMapExample(){
		
		class Employee {
			String name;
			int salary;
			Employee(String name, int salary){
				this.name= name;
				this.salary= salary;
			}
			
			public String toString(){
				return "Name: "+name+" salary: "+salary;
			}
		}
		
		class MyCompNameEmployee implements Comparator<Employee> {
			public int compare(Employee o1, Employee o2) {
				return o1.name.compareTo(o2.name);
			}
		}
		
		class MyCompSalaryEmployee implements Comparator<Employee> {
			public int compare(Employee o1, Employee o2) {
				return o1.salary - o2.salary;
			}
		}
		
		System.out.println("TreeMap with NameComparator");
		
		TreeMap<Employee,String> tm = new TreeMap<Employee,String>(new MyCompNameEmployee());
		
		tm.put(new Employee("srikanth",10000), "SRIKANTH");
		tm.put(new Employee("Ruthvika", 15000),"RUTHVIKA");
		tm.put(new Employee("Vinisha",5000), "VINISHA");
		Set<Employee> ks = tm.keySet();
        for(Employee key:ks){
            System.out.println(key+" ==> "+tm.get(key));
        }
        
		System.out.println("TreeMap with SalaryComparator");
		
		TreeMap<Employee,String> tm1 = new TreeMap<Employee,String>(new MyCompSalaryEmployee());
		
		tm1.put(new Employee("srikanth",10000), "SRIKANTH");
		tm1.put(new Employee("Ruthvika", 15000),"RUTHVIKA");
		tm1.put(new Employee("Vinisha",5000), "VINISHA");
		Set<Employee> ks1 = tm1.keySet();
        for(Employee key:ks1){
            System.out.println(key+" ==> "+tm.get(key));
        }
		
	}

	//From here Map usage
}
