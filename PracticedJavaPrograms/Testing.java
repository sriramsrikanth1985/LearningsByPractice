import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Testing {
	private HashMap<String, String> hm = new HashMap<String,String>();

	public HashMap<String, String> getHm() {
		return hm;
	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
/*		String test = "AccessKey|13";
		String[] gacNameWithTypeArr = test.split("\\|");
		System.out.println(gacNameWithTypeArr.length);
		System.out.println("gacName: "+gacNameWithTypeArr[0]+" gacType:"+gacNameWithTypeArr[1]);
		String gacName = gacNameWithTypeArr[0];
		int gacType = Integer.parseInt(gacNameWithTypeArr[1]);
		System.out.println("gacName: "+gacName+" gacType:"+gacType);*/
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
		
		String date="2016-01-13 08:47:49";
		System.out.println(sdf.format(df.parse(date)));
		

		//hm.put("hi", "hello");
		
	}

}
