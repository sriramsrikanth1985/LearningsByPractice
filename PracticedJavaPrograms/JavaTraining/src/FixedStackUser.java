
public class FixedStackUser {
	
	public static void main(String[] args) {
		System.out.println("Fixed Stack array implementation");
		FixedArrayStack fas = new FixedArrayStack();
		fas.push(10);
		fas.push(20);
		System.out.println("Array: "+fas.toString());
		fas.pop();
		System.out.println("Array: "+fas.toString());

	}

}
