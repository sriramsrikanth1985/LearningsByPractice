package intellipaat;

public class ToTestGetNameAndGetClass {
	
	public ToTestGetNameAndGetClass() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static void main(String args[]){
		try{
		ToTestGetNameAndGetClass obj = new ToTestGetNameAndGetClass();
		System.out.println("GetClass: "+obj.getClass());
		System.out.println("ForName: "+Class.forName("ToTestGetNameAndGetClass").getClass().getName());
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
