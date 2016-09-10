
public class NullCheck {
public static void main(String args[]){
	String test = "";
	if(test.equals("12"))
		System.out.println("empty string");
	else if(test == null)
		System.out.println("null string");
}
}
