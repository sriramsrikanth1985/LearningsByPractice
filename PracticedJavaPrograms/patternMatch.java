import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class patternMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//final Pattern PATTERN_ONGOING = Pattern.compile("(.*)_(\\d+)_(\\d+)_(.*)(.oevt)"); 
		final Pattern PATTERN_ONGOING =Pattern.compile("(.*)_(\\d+)(.compress)");
		
		
		//Matcher _currentFileNameMatcher = PATTERN_PREPROC_ONGOING.matcher("1_1_1396947785992094_VoMSLibrarybatch.xml.oevt");
		//Matcher _currentFileNameMatcher = PATTERN_PREPROC_ONGOING.matcher("CEID_PPID_1396947785992094_abc_x.1234y__z_wer_4_.oevt");
		Matcher _currentFileNameMatcher = PATTERN_ONGOING.matcher("abc_xyz.res_1396947785992094.compress");
		
        if(_currentFileNameMatcher.matches()){
        	System.out.println("Its matching");
        	System.out.println(_currentFileNameMatcher.group(1));
        } else
        	System.out.println("Its not matching");
        
        
        
        
/*        final Pattern PATTERN_PREPROC_ONGOING = Pattern.compile("(.*)(.oevt)_(.*)__(.*)_(\\d+)");
		Matcher _currentFileNameMatcher_preproc = PATTERN_PREPROC_ONGOING.matcher("ab_c.oevt_hostname__PID_1396947785992094");
		
        if(_currentFileNameMatcher_preproc.matches()){
        	System.out.println("Its matching");
        	System.out.println(_currentFileNameMatcher_preproc.group(1));
        } else
        	System.out.println("Its not matching");*/
	}

}
