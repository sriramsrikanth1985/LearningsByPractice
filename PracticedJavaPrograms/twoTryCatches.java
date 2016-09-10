
public class twoTryCatches {
	public static void main(String args[]){
		try{
			System.out.println("printing try1");
		} catch(Exception e){
			System.out.println("inside exception of try1"+e.getMessage());
			e.printStackTrace();
			try{
				System.out.println("printing try2");
			}catch(ArithmeticException ae){
				System.out.println("inside exception of try2"+ae.getMessage());
				ae.printStackTrace();
			}
		}

	}

}
