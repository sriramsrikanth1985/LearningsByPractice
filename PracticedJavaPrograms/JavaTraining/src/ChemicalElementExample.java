
public class ChemicalElementExample {

	public static String metalType;
	public int metalNumber;
	public String name;
	
	public static boolean isAlkaliMetal(ChemicalElementExample ref){
		int metalType = ref.metalNumber;
		
		switch(metalType){
			case 3:
			case 11:
			case 19:
			case 37:
			case 35:
			case 87:
				return true;
			default:
				return false;
		}
		
	}
	
	
	public static boolean isTransitionalMetal(ChemicalElementExample ref) {
		int metalType = ref.metalNumber;
		switch(metalType){
		case 21-31:
		case 39-48:
		//case 72-80:
		//case 104-112:
			return true;
		default:
			return false;
	}
	}
	
	public static boolean isChemicalMetal(ChemicalElementExample ref) {
		int metalType = ref.metalNumber;
		switch(metalType){
		case 13:
		case 49:
		case 50:
		case 81:
		case 82:
		case 83:
		case 113:
		case 114:
		case 115:
		case 116:
			return true;
		default:
			return false;
		}
	}
	
	//constructor
	public ChemicalElementExample(int metailNum, String name) {
		// TODO Auto-generated constructor stub
		this.metalNumber = metailNum;
		this.name = name;
	}
	
	public static void main(String[] args) {
		
		ChemicalElementExample metal1=new ChemicalElementExample(3,"Hydrogenium");
		System.out.println("MetalName: " + metal1.name+ "\t"+ isAlkaliMetal(metal1));
		System.out.println("MetalName: " + metal1.name+ "\t"+  isTransitionalMetal(metal1));
		System.out.println("MetalName: " + metal1.name+ "\t"+  isChemicalMetal(metal1));
	}

}
