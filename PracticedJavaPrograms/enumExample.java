
public class enumExample {
	
	public enum Result {
		New(0),
		Modified(1),
		Duplicate(2),
		UnSet(3);
		
		public int value;
		Result(final int v){
			this.value = v;
		}
	};
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = 2;
System.out.println("Hello: "+Result.Duplicate.toString());
System.out.println("Hi: "+Result.Duplicate.value);
/*		if(test == Result.Modified.value)
			System.out.println("hi, yes in modified "+Result.valueOf("New").value);*/
System.out.println(Result.Modified.value);


/*switch(test){
case Result.Modified.value:
	break;
	
}*/

	}

}
