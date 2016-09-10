package interview.questions.fresher;

import java.util.Scanner;

public class StringToLowerWithoutBuiltInFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the string");
		Scanner scan = new Scanner(System.in);
		String inputStr = new String(scan.nextLine());
		
		char[] lowerStr = new char[inputStr.length()];
		int cnt=0;
		for(char c:inputStr.toCharArray()){
			if(c>=65 && c<=90)
				lowerStr[cnt] = (char)(c+32);
			else
				lowerStr[cnt] = (char) c;
			//System.out.println(lowerStr[cnt]);
			cnt++;
		}
		System.out.println(lowerStr);

	}

}
