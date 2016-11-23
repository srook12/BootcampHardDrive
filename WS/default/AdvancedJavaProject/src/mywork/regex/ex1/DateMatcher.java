package mywork.regex.ex1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateMatcher {

	public static void main(String[] args) {
		//String regex = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
		//String regex = "(0{0,1}[1-9]|1[012])/";
		String regex = "(0?[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01])/(\\d{4})";
		//String regex = "2[3-9]|[3456]\\d|7[0-2]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("73");
		
		System.out.println(matcher.matches());
	}

}
