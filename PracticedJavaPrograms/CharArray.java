
public class CharArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line1 = "phackerekarthj";
		String line2 = "jhakckerearthp";
    	char[] ch1 = line1.toCharArray();
    	char[] ch2 = line2.toCharArray();
    	CharArray ca = new CharArray();
    	if(ca.isSubSequence(ch1, ch2, ch1.length, ch2.length))
    		System.out.println("yes");
    	else
    		System.out.println("no");
/*    	System.out.println(line2);
    	
    	for(char c:ch){
    		System.out.println(c);
    	}*/
	}
	
	boolean isSubSequence(char str1[], char str2[], int m, int n)
	{
	    // Base Cases
	    if (m == 0) return true;
	    if (n == 0) return false;
	 
	    // If last characters of two strings are matching
	    if (str1[m-1] == str2[n-1])
	        return isSubSequence(str1, str2, m-1, n-1);
	 
	    // If last characters are not matching
	    return isSubSequence(str1, str2, m, n-1);
	}

}
