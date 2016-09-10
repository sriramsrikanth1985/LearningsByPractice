
public class FibonacciSeriesUsingRecursive {
	int temp = -1;
	
	public void printSeries(int num1, int num2) {
		if(num2 < 100){
			temp = num1;
			num1=num2;
			num2=temp+num2;
			System.out.println(num2);
			printSeries(num1,num2);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciSeriesUsingRecursive fb = new FibonacciSeriesUsingRecursive();
		System.out.println(0);
		System.out.println(1);
		fb.printSeries(0, 1);
	}

}
