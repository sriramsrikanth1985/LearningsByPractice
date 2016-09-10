
public class SplitDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName = "STBD7662__TB-4004-20120709155308.oevt_blnfj1450__31748_201207091352";
		String[] result = fileName.split("_");
		String newFileName = "";
		for(int i=0;i<(result.length - 4); i++){
			if(newFileName == "")
				newFileName = result[i];
			else
				newFileName = newFileName+"_"+result[i];
		}
		System.out.println("newFileName: "+newFileName);
			

	}

}
