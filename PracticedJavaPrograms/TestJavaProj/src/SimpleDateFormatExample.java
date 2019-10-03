import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {

	/**
	 * @param args
	 * @throws ParseException
	 */
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy G");
		Date d = new Date();
		System.out.println(d);
		
		System.out.println(sdf.parse("0/0/2017 AD"));

	}

}
