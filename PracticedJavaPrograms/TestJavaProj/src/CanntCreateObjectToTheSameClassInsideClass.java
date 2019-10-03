
public class CanntCreateObjectToTheSameClassInsideClass {

	CanntCreateObjectToTheSameClassInsideClass(String str){
		System.out.println("inside Test constructor"+str);
	}

	//This gives stackOverFlow Exception
	//CanntCreateObjectToTheSameClassInsideClass test1 = new CanntCreateObjectToTheSameClassInsideClass(" FromClass");
	
	//This works fine
	static CanntCreateObjectToTheSameClassInsideClass test = new CanntCreateObjectToTheSameClassInsideClass(" FromClass");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CanntCreateObjectToTheSameClassInsideClass t = new CanntCreateObjectToTheSameClassInsideClass(" FromMain");
	}

}
