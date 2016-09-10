package intellipaat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

/**
 * 
 * @author ssriram
 * 1. Type safety
 * 2. No Typecast required while reading
 * 3. Compilation time error
 * 
 * In a nutshell, generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods. 
 * Much like the more familiar formal parameters used in method declarations, type parameters provide a way for you to re-use the same code with different inputs. 
 * The difference is that the inputs to formal parameters are values, while the inputs to type parameters are types.
 
 * Code that uses generics has many benefits over non-generic code:
 	* Stronger type checks at compile time.
		A Java compiler applies strong type checking to generic code and issues errors if the code violates type safety. 
		Fixing compile-time errors is easier than fixing runtime errors, which can be difficult to find.

 	* Elimination of casts.
		The following code snippet without generics requires casting:
			List list = new ArrayList();
			list.add("hello");
			String s = (String) list.get(0);
		When re-written to use generics, the code does not require casting:
			List<String> list = new ArrayList<String>();
			list.add("hello");
			String s = list.get(0);   // no cast
	* Enabling programmers to implement generic algorithms.
By using generics, programmers can implement generic algorithms that work on collections of different types, can be customized, and are type safe and easier to read.
 */

public class GenericsExample {
	
	public static void main(String args[]){
		
	
		//genericCollection();
		//genericMap();
		//genericClass();
		System.out.println("Hello calling genericWildCart");
		genericWildCard();
		
		
		
	}
	
	static void genericWildCard(){
		
		/**
		 * Wild cards are List with ? --> without any type defined. At run time whichever type gets it will accept
		 * Three types of wild cards
		 * 1. Unbounded wildcard List<?>
		 * 2. Extends wildcard List<? extends superClass>
		 * 3. Super wildcard List<? super superClass>
		 */
		
		myGeneric<Integer> my = new myGeneric<>();
		my.addEle(1);my.addEle(2);my.addEle(3);
		
		myGeneric<String> myStr = new myGeneric<>();
		myStr.addEle("alpha");myStr.addEle("beta");myStr.addEle("gamma");


	//--------------------------- 
		//Unbounded wild cart example
		wildCardDemo(my.list);
		wildCardDemo(myStr.list);
		
	//---------------------------
		
		//Bounded wild cart example
		//here in this example only the Numbers are acceptable
		List<Integer> li = new ArrayList<>();
		li.add(1);
		li.add(2);
		li.add(3);
		wildCardExtendsDemo(li);
		
		List<Float> listFloat = new ArrayList<>();
		listFloat.add(1.0f); 
		listFloat.add(2.12f);
		listFloat.add(3.13f);
		wildCardExtendsDemo(listFloat);
		
		List<Long> listLong = new ArrayList<>();
		listLong.add(1L);
		listLong.add(2L);
		listLong.add(3L);
		wildCardExtendsDemo(listLong);
		
		List<Vehicle> listVehicle = new ArrayList<>();
		listVehicle.add(new Car());
		listVehicle.add(new Motorcycle());
		//listVehicle.add(new Fruit()); --> this gives compilation error
		wildCardExtendsVehicleDemo(listVehicle);
		
		
	}
	
	static <X> void wildCardDemo(List<X> l){
		for(Object o:l){
			System.out.println(o);
		}
	}
	
	/**
	 * Since this method argument wildCart extends Number, it will accept Integer, Float, Decimal only not String
	 * @param l
	 */
	static void wildCardExtendsDemo(List<? extends Number> l){
		for(Object o:l){
			System.out.println(o.toString());
		}
	}
	
	/**
	 * The meaning of <? extends Vehicle> is: I don't care what the type parameter is, as long as it is a subclass of Vehicle.
	 * @param l
	 * Bounds in method parameters
	 */
	static void wildCardExtendsVehicleDemo(List<? extends Vehicle> l){
		for(Object o:l){
			System.out.println(o.getClass());
		}
	}
	
	
	
	static void genericClass() {
		myGeneric<Integer> my = new myGeneric<>();
		my.addEle(1);my.addEle(2);my.addEle(3);
		System.out.println("my contents: "+my.list);
		my.removeEle();
		System.out.println("my contents after remove: "+my.list);
		
		myGeneric<String> myStr = new myGeneric<>();
		myStr.addEle("alpha");myStr.addEle("beta");myStr.addEle("gamma");
		System.out.println("myStr contents: "+myStr.list);
		myStr.removeEle();
		System.out.println("myStr contents after remove: "+myStr.list);
		
		System.out.println("is 1 present: "+isPresent(1,my.list));
		System.out.println("is beta present: "+isPresent("beta", myStr.list));
	}
	
	//Generic method
	static <T> boolean isPresent(T al, Collection<T> c){
		for(T tc:c) {
			if(tc.equals(al))
				return true;
			else
				continue;
		}
		return false;
	}
	
	static void genericCollection(){
		List<Integer> intList = new ArrayList<>();
		List<String> strList = new ArrayList<>();
			
		intList.add(1);intList.add(2);intList.add(3); //intList.add("sri"); this gives error
		System.out.println("intList: "+intList);
		strList.add("alpha");strList.add("beta");strList.add("gamma");
		System.out.println("strList: "+strList);
	}
	
	static void genericMap(){
		//Generics Map
		Map<Integer,String> m = new HashMap<>();
		m.put(1, "alpha");
		m.put(2,"beta");
		m.put(3, "gamma");
		//m.put("sri","kanth"); --> gives compilation error
		System.out.println("hashmap contents: "+m);
	}

}

class myGeneric<T> {
	LinkedList<T> list = new LinkedList<>();
	void addEle(T obj){
		list.addLast(obj);
	}
	void removeEle(){
		list.removeFirst();
	}
}

class Vehicle{}
class Car extends Vehicle { }
class Motorcycle extends Vehicle { }
class Fruit extends Object { }
interface PassengerVehicle { }
interface MotorVehicle { }

/**
 * Class Bounds
 * You often want to restrict the set of types that can be used in instantiation. 
 * If you create a class Garage, you want it to hold only Vehicle objects.
 * @author ssriram
 *
 * @param <X>
 */
class ParkingGarage<X extends Vehicle & MotorVehicle & PassengerVehicle> {}