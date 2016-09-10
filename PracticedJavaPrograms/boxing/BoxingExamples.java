package boxing;

public class BoxingExamples {
	public static void main(String args[]){
		int i = 10;
		
		Integer I = new Integer(5); //Boxing example
		Integer J = i; //AutoBoxing example
		int j = J; //Unboxing exampple
		
		System.out.println("I: "+I);
		System.out.println("J: "+J);
		System.out.println("j: "+j);
	}
}
