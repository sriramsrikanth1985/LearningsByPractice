package collections.List;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
	
	public static void main(String args[]) {
		ArrayList<String> arr = new ArrayList<String>();  //ordered collection
		arr.add("sri"); //Adding an element to arrayList
		arr.add("kanth");
		
		System.out.println("contains sri: "+arr.contains("sri")); //contains will return true if the given element is in ArrayList
		System.out.println("Second element:" +arr.get(1)); //get method will return the element at given index
		
		arr.add(1, "hello");
		arr.add("sri"); //List can have duplicates, hence no exception/error
/*		
		System.out.println(arr.toString());
		
		arr.remove(0); //removes the element at the given index
		arr.set(1, "hey"); //set replaces the element at the given index
		System.out.println("size: "+arr.size()); //size methods gives the number of elements in the arrayList
		System.out.println(arr.toString()); //printing the arrayList contents
		Iterator<String> itrArr = arr.iterator();
		while(itrArr.hasNext())
			System.out.println((String)itrArr.next());
		
		for(String oneEle: arr)
			System.out.println(oneEle);*/
		
		System.out.println(arr.toString());
		
	}

}
