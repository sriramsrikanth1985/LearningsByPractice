import java.io.File;


public class substring {
	public static void main(String args[]){
		String rerid="abc123xyz.res";
		//System.out.println("the substring:"+str1.substring(5));
		
/*    	if(rerid.startsWith("test_")){
    		System.out.println("inside test_");
    		System.out.println("the substring:"+Integer.parseInt(rerid.substring(5)));
    	}
    	else
    		System.out.println("the substring:"+Integer.parseInt(rerid));*/
		
/*		String OrigFileName = rerid;
		if(!OrigFileName.endsWith(".res")) {
			System.out.println(OrigFileName);
		} else {
			//File has .res extenstion, so this extn should be removed and file is to be placed in rater/input directly
			System.out.println(OrigFileName.substring(0,OrigFileName.length()-4));
		}*/
		
		String s = new String("ABC"); 
		s.toLowerCase(); 
		s += "def"; 
		System.out.println(s);
	}

}
