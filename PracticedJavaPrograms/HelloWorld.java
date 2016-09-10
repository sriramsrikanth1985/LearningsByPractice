
public class HelloWorld {
	
	public int multiply(int int1,int int2){
		return int1*int2;
		//return 4;
	}
	public static void main(String args[]){
		//System.out.println("Hello World !!");
		String[] arr = new String[4];
		arr[0]=new String("hi");
		arr[1]=new String("hello");
		arr[2]=new String("kanth");
		arr[3]=new String("sri");
		
		for(String str:arr){
			System.out.println(str.toString());
		}
	}
}
