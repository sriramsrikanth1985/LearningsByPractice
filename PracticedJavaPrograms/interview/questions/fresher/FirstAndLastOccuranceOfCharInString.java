package interview.questions.fresher;

import java.util.Scanner;

public class FirstAndLastOccuranceOfCharInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the string");
		Scanner scan = new Scanner(System.in);
		String inputStr = new String(scan.nextLine());
		System.out.println("Please enter the char for index");
		char ch = scan.next().charAt(0);
		System.out.println("char: "+ch);
		int len = inputStr.length();
		for(int i=0;i<len;i++){
			if(inputStr.charAt(i) == ch){
				System.out.println("First occurance at index: "+(i+1));
				break;
			}
		}
		
		for(int i=len-1;i>=0;i--){
			if(inputStr.charAt(i) == ch){
				System.out.println("Last occurance at index: "+(i+1));
				break;
			}
		}
	}

}
