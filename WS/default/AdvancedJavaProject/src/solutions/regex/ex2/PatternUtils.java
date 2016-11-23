package solutions.regex.ex2;

import java.util.regex.Pattern;

public class PatternUtils {
	private static final String MONTH =
		"(0{0,1}[1-9]|1[012])";
	private static final String DAY =
		"(0{0,1}[1-9]|[12][0-9]|3[01])";
	private static final String YEAR =
		"\\d{4}";
	
	public static Pattern getDatePattern(){
		return getDatePattern("/");
	}
	
	public static Pattern getDatePattern(String d){
		String full = MONTH + d + DAY + d + YEAR;
		return Pattern.compile(full);
	}
}
