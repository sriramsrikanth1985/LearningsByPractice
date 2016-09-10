package interview.questions.fresher;

import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NumberOfWordsInSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the sentence to identify the number of words");
		Scanner scan = new Scanner(System.in);
		String inputStr = new String(scan.nextLine());
		StringTokenizer st = new StringTokenizer(inputStr);
		System.out.println("number of words: "+st.countTokens());
		
		HashSet hs = new HashSet();
		while(st.hasMoreElements())
			hs.add(st.nextToken());
		
		System.out.println(hs);

	}

}
