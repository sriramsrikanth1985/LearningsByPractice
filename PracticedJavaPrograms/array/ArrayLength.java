package array;

public class ArrayLength {
	public static void main(String args[]){
		int[] a = new int[50];
		int[][] b = new int[50][50];
		System.out.println(a.length);
		System.out.println(b.length);
		
		for(int a1: a)
			System.out.println(a1);
	}
}
