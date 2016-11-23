package mywork.regex.ex5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipcodeTester {

	public static void main(String[] args) {
		String zip1 = "1234-12345";
		Pattern pattern = Pattern.compile("(\\d{5})|\\d{5}\\-\\d{4}");
		Matcher matcher = pattern.matcher(zip1);
		
		if(matcher.matches()) {
			System.out.println("Valid zip code!");			
		} else {
			throw new java.util.UnknownFormatConversionException("Invalid zip!");			
		}
	}

}
