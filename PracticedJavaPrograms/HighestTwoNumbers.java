import java.util.ArrayList;


public class HighestTwoNumbers {

	public void printTwoNumbers(int[] arr){
		int firstNum = 0;
		int secondNum = 0;
		for(int num:arr){
			if(num > firstNum){
				secondNum = firstNum;
				firstNum = num;
			} else if(num > secondNum)
				secondNum = num;
		}
		
		System.out.println("First num: "+firstNum);
		System.out.println("Second num: "+secondNum);
		
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,5,9,2,8,4,89,3,45,4,678,456};
		HighestTwoNumbers h2n = new HighestTwoNumbers();
		h2n.printTwoNumbers(arr);

	}

}
