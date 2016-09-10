
public class SuperSubClassInstanceOf {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SuperClass sp1 = new SuperClass();
		SubClass sb1 = new SubClass();
		
		if(sp1 instanceof SuperClass){
			System.out.println("sp1 is instance of SuperClass");
		} else {
			System.out.println("sp1 is not instance of SuperClass");
		}
		
		if(sp1 instanceof SubClass){
			System.out.println("sp1 is instance of SubClass");
		} else {
			System.out.println("sp1 is not instance of SubClass");
		}
		
		if(sb1 instanceof SuperClass){
			System.out.println("sb1 is instance of SuperClass");
		} else {
			System.out.println("sb1 is not instance of SuperClass");
		}
		
		if(sb1 instanceof SubClass){
			System.out.println("sb1 is instance of SubClass");
		} else {
			System.out.println("sb1 is not instance of SubClass");
		}

	}
};
class SuperClass{};

class SubClass extends SuperClass {};
