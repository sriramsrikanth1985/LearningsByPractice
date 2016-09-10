package interview.questions.fresher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class KthHighestElementInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the size of the matrix");
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int a=0,b=0;
		LinkedHashSet hs = new LinkedHashSet<Integer>();
		int[][] mat = new int[m][n]; 
		System.out.println("please enter the elements of matrix "+m+"X"+n);
		
		for(a=0;a<m;a++){
			for(b=0;b<n;b++) {
				mat[a][b]=in.nextInt();
				hs.add(mat[a][b]);
			}
		}
		System.out.println("matrix"+mat);
		System.out.println("HashSet:"+hs);
		ArrayList<Integer> arr = new ArrayList<Integer>(hs);
		Collections.sort(arr);
		
		System.out.println("Array:"+arr);

		
	}

}
