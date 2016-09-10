import java.util.HashMap;
import java.util.Scanner;


public class FirstNonRepeated {
	public static void main(String args[]){
		System.out.println("please enter the string");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println("Entered string: "+input);
		
		char c = firstNonRepeatedChar(input);
		System.out.println("The first non repeated char is: "+c);
	}

	private static char firstNonRepeatedChar(String inputStr) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> characterHashMap = new HashMap<Character, Integer>();
		Character c;
		int i,lenght = inputStr.length();
		for(i=0;i<lenght;i++) {
			c=inputStr.charAt(i);
			
			if(characterHashMap.containsKey(c)){
				characterHashMap.put(c, characterHashMap.get(c)+1);
			} else {
				characterHashMap.put(c,1);
			}
		}
			
			System.out.println("printing the characterHashMap: "+characterHashMap);
			
			//finding the first char with numberOfExists=1
			for(i=0;i<characterHashMap.size();i++){
				c=inputStr.charAt(i);
				if(characterHashMap.get(c) == 1)
					return c;
			}
		
		return 0;
	}
}
