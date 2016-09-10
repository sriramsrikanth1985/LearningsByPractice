
//package com.sw.conn;

//import com.sw.teimplemest.Fibonac;


public class Fibo{
 static int var=887;
 
 public static void main(String args[]){
	 //do{
	 //var%10 --> last digit
	 //sum=sum+lastDigit
	 //var/10 --> reminder part
	 //}while(var == 0)
	 
	 Fibo fb = new Fibo();
	 
	 System.out.println("sum: "+fb.getSumOfDigits(var));
	
 }
 
 int getSumOfDigits(int var){
	 int sum=0;
	 int lastDigit = 0;
	 int localVar = var;
	 do{
		 lastDigit=localVar%10;
		 sum = sum+lastDigit;
		 localVar=localVar/10;
		 System.out.println(lastDigit);
		 System.out.println(sum);
		 System.out.println(localVar);
	 }while (localVar != 0);
	 
	 return sum;
 
}
}
