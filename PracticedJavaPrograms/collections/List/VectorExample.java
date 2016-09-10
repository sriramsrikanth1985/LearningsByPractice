package collections.List;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample {
	public static void main(String args[]){
		Vector<Object> vec = new Vector<Object>(); //ordered collection, to be considered with thread safety is concern
		vec.add("sri");
		vec.add("hello"); //Adding the element at last
		vec.add(2, "kanth"); //Adding element at index 2
		vec.add("sri"); //List can have duplicates
		vec.remove(3); //removing the element at index 3
		vec.set(2, "hey"); //Replacing the element at index 2
		vec.add(1.23);
		System.out.println("get second element: "+vec.get(1)); // Getting the element at index 1
		System.out.println("size of vector: "+vec.size()); //Getting the size of vector
		System.out.println(vec.toString()); //Printing the contents of vector
		

		
		//for(Object obj:vec)
		//	System.out.println(obj);
		
		Iterator<Object> itr = vec.iterator();
		while(itr.hasNext()){
			Object obj = itr.next();
			if(obj.equals(1.23))
				itr.remove();
			System.out.println(obj);
		}
		
		for(Object obj:vec)
			System.out.println(obj);
		
		
	}

}
