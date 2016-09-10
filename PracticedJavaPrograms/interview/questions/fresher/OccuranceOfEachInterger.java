package interview.questions.fresher;

import java.util.HashMap;
import java.util.Scanner;


public class OccuranceOfEachInterger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap hash = new HashMap();
		System.out.println("Please enter the number of intergers input");
		Scanner scan = new Scanner(System.in);
		int numOfInts = scan.nextInt();
		
		for(int i=numOfInts;i>0;i--){
			int key = scan.nextInt();
			if(hash.containsKey(key)){
				int value =  (Integer) hash.get(key);
				hash.put(key, value+1);
				System.out.println(hash);
			} else
				hash.put(key, 1);
		}
		
		System.out.println(hash);

	}

}
