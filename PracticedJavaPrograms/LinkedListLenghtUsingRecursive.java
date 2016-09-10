import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class LinkedListLenghtUsingRecursive {
	
	public static int len = 0;
	public static Iterator itr = null;
	
	public static void findLength(){
		if(itr.hasNext()){
			len++;
			itr.next();
			findLength();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue q = new LinkedList<Integer>();
		
		
		LinkedList ll1 = new LinkedList<Integer>();
		
		
		LinkedList ll = new LinkedList();
		ll.add(9);
		ll.add(5);
		ll.add(8);
		ll.add(4);
		ll.add("hello");
		ll.add(34L);
		
		for(Object obj:ll){
			System.out.println(obj);
		}
		
/*		itr = ll.iterator();
		findLength();
		System.out.println("Length of the list: "+len);*/
	}

}
