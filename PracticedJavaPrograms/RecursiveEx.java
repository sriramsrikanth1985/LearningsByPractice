
public class RecursiveEx {
	
	public static String str = new String("srikanth");
	
	public void printChar(int index){
		if(index>=0){
			System.out.print(str.charAt(index));
			index--;
			printChar(index);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursiveEx r = new RecursiveEx();
		r.printChar(RecursiveEx.str.length()-1);
	}

}
