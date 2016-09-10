public class IntegerSumTestNew {

	public static void main(String[] args) {
		IntegerSumTestNew ist = new IntegerSumTestNew();
		ist.testSum();
	}
	
	public void testSum(){
		long l= 0;
		for(int i= Integer.MIN_VALUE;i<=Integer.MAX_VALUE;i++)
		{
			l+=i;
		}
		System.out.println(l);
	}
} 