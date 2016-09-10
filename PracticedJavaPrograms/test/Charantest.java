package test;

import java.io.File;
import java.io.RandomAccessFile;

public class Charantest {
	
	public static void main(String args[]){

		try {
			callException();
		} catch (myException e) {
			// TODO Auto-generated catch block
			try{
				System.out.println(e.getMessage().charAt(2));
/*				if(e.getMessage() != null){
					System.out.println(e.getMessage().charAt(2));
				} else {
					System.out.println("e.getMessage is null");
				}*/
			}catch(Exception e1){
				System.out.println("Exception at char reading: "+e1.getMessage());
			}
		}
		
	}
private static void callException() throws myException {
		//throw new myException("Charan");
	throw new myException();
		
	}
static class myException extends Exception{
	
/*	myException(String s){
		super(s);
	}*/
}
}
