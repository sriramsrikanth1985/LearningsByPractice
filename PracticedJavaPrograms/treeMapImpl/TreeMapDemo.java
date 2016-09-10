package treeMapImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		//TreeMap tm = new TreeMap(); or
		TreeMap<String, Double> tm = new TreeMap<String, Double>();
		tm.put("sri",new Double(123.1));
		tm.put("kanth", new Double(456.1));
		tm.put("srikanth", new Double(789.1));
		tm.put("abc", new Double(789.12));
		//tm.put("sri", new Double(78912.12)); If key value is same, then it is over riding the value
		
		Set set = tm.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext()){
			Map.Entry me = (Map.Entry) itr.next();
			System.out.println("key: "+me.getKey()+ " value: "+me.getValue());
		}
		
		//deposit 1000 into kanth's account
		Double bal = ((Double) (tm.get("kanth"))).doubleValue();
		tm.put("kanth", bal+123);
		
		System.out.println(tm.toString());*/
		
		//TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		HashMap<Integer, String> tm = new HashMap<Integer, String>();
		tm.put(1, "Redeem");
		tm.put(2,"Redeem");
		tm.put(3,"Collect");
		if(tm.get(2) == null)
			tm.put(2,"Collect");
		else
			System.out.println("not inserted");
		
		System.out.println(tm.keySet());
/*		Iterator itr = tm.keySet().iterator();
		int counter = 1;
		while( itr.hasNext()){
			if(counter != Integer.parseInt(itr.next().toString())) {
				System.out.println("error");
				break;
			} else
				counter++;
		}*/
		System.out.println("tm.size():"+tm.size());
		System.out.println("tm.keySet().size()"+tm.keySet().size());
		System.out.println("Collections.max(tm.keySet()): "+Collections.max(tm.keySet()));
		
		if(tm.keySet().size() != Collections.max(tm.keySet()))
			System.out.println("error");
		
	}

}
