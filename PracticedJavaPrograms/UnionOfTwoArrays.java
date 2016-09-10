import java.awt.List;
import java.util.TreeSet;

import antlr.debug.TraceAdapter;


public class UnionOfTwoArrays {
	
	public Integer[] unionArray(int[] array1, int[] array2){
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		for(int num:array1){
			ts.add(num);
		}
		
		for(int num:array2){
			ts.add(num);
		}
		
		return ts.toArray(new Integer[0]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {1,5,8,0};
		int[] arr2 = {5,8,1,0,6,2,3};
		
		UnionOfTwoArrays u = new UnionOfTwoArrays();
		Integer[] ret = u.unionArray(arr1, arr2);
		
		for(int num:ret){
			System.out.print(num+" ");
		}
	}

}
