package com.sri.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ArrayList<String> animalArray = new ArrayList<String>();
		List<String> animalArray = new ArrayList<String>();
		//ArrayList<String> animalArray = new ArrayList<String>();
		animalArray.add("lion");
		animalArray.add("tiger");
		animalArray.add("duck");
		
		Iterator<String> animalItr = animalArray.iterator();
		while(animalItr.hasNext()) {
			System.out.println(animalItr.next());
			animalArray.add("hell");
		}
		
		animalArray.remove(1);
		animalArray.add("horse");
		System.out.println("-----------");
		
		for(String arrayEle : animalArray) {
			System.out.println(arrayEle);
			//animalArray.add("Str");
		}
	}

}
