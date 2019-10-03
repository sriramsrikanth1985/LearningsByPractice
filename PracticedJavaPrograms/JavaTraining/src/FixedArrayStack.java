
public class FixedArrayStack implements Stack {
	
	public int[] intArray;
	public int index;
	
	public FixedArrayStack() {
		intArray = new int[10];
		index=-1;
	}

	@Override
	public void push(Object obj) {
		intArray[++index]= (int)obj;

	}

	@Override
	public Object pop() {
		int ele = intArray[index];
		return (Object)ele;
	}

}
