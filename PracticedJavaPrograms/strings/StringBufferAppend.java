package strings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringBufferAppend {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		StringBuffer sb = new StringBuffer();
		//sb.append("hello",2,"hello".length());
		sb.append("srikanth");
		System.out.println(sb);
		String comp = sb.toString();
		if(comp.equalsIgnoreCase("srikanth"))
			System.out.println("success");*/
		
		
		List<String> list = new ArrayList<String>();
		list.add("hi");
		list.add("hello");
		list.add("sri");
		list.add("kanth");
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
