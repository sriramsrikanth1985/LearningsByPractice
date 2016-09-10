package treeMapImpl;

import java.util.Random;
import java.util.TreeMap;

import javassist.bytecode.Descriptor.Iterator;

public class OrderingInTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		Random rand = new Random(); 
		TreeMap<Character, Integer> tmap = new TreeMap<Character, Integer>(); 
		tmap.put('Z', rand.nextInt()); 
		tmap.put('a', rand.nextInt()); 
		tmap.put('A', rand.nextInt()); 
		tmap.put(' ', rand.nextInt()); 
		tmap.put('@', rand.nextInt()); */
		
		
		
		Random rand = new Random(); 
		TreeMap<String, Integer> tmap = new TreeMap<String, Integer>(); 
		tmap.put("ZEBRA", rand.nextInt()); 
		tmap.put("Algebra", rand.nextInt()); 
		tmap.put("ALgebra", rand.nextInt()); 
		tmap.put("1 point", rand.nextInt()); 
		tmap.put("Zebra", rand.nextInt()); 
		tmap.put(" ", rand.nextInt()); 
		tmap.put("@gmail.com", rand.nextInt()); 
		tmap.put("@Gmail.Com", rand.nextInt()); 
		//printKeys(tmap.keySet());
		
		java.util.Iterator<String> itr = tmap.keySet().iterator();
		//printKeys(tmap.keySet());
		while(itr.hasNext()) {
			String key = itr.next();
			System.out.println(key+":"+tmap.get(key));
		}

	}

}
