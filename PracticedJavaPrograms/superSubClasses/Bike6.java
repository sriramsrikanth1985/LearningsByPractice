package superSubClasses;

class Vehicle{  


static {
	System.out.println("Hello");
}
Vehicle(){System.out.println("Vehicle is created");}  
}  
	  
	class Bike6 extends Vehicle{  
	  int speed;  
	  Bike6(int speed){ 
		  System.out.println("Inside Bike6 constructor");
	    this.speed=speed;  
	    System.out.println(speed);  
		  System.out.println("Inside Bike6 constructor completed");
	  }  
	  public static void main(String args[]){  
	   Bike6 b=new Bike6(10);  
	 }  
	} 