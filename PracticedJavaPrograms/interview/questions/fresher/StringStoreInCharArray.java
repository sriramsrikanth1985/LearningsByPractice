package interview.questions.fresher;

public class StringStoreInCharArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hello = "srikanth";
		int len=hello.length();
		char[] byReadingEachChar = new char[len];
		//System.out.println("len: "+len);
		try{
		for(int i=0;i<len;i++){
			byReadingEachChar[i] = hello.charAt(i);
		}
		System.out.println(byReadingEachChar);
		}catch(Exception e){
			System.out.println("in exception"+e.getMessage());
		}

	}

}
