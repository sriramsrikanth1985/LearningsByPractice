import java.util.ArrayList;


//package com.sw.conn;

//import com.sw.teimplemest.Fibonac;


public class FiboNew{

 
 public static void main(String args[]){
	 //get last and lastButOne intergers in an array
	 //sum these and insert into the same array till the size of array is numb=20
	 
	 // 0 1 1 2 3 5 8 
	 
	 int numb=20;
	 ArrayList<Integer> fb = new ArrayList<Integer>();
	 
	 FiboNew fbNew = new FiboNew();
	 fb.add(0);
	 fb.add(1);
	 
	 fbNew.recursive(fb);
	 
	 System.out.println("fibonocci series: "+fb);
	
 }
 
	 void recursive(ArrayList<Integer> fb){
		 //System.out.println(fb);
		 //System.out.println(fb.size());
	int size = fb.size();
		if(size == 20){
			return;
		}
		
		fb.add(fb.get(size-1)+fb.get(size-2));
		recursive(fb);
	 
	}
 
 
}
