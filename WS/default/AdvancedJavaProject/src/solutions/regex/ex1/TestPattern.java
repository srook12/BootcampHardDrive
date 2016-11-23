package solutions.regex.ex1;

import java.io.*;
import java.util.regex.*;

public class TestPattern {
	private static BufferedReader kb = new BufferedReader(
			new InputStreamReader(System.in));

	public static void main(String[] args) {
		String msg = "Please enter a date: ";
		Matcher m;
		boolean found;
		Pattern p = PatternUtils.getDatePattern();
		while (true) {
			m = p.matcher(prompt(msg));
			found = m.matches();
			print("Match Results: " + found);
		}
	}

	private static String prompt(String s) {
		String userText = null;
		try {
			print(s);
			userText = kb.readLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return userText;
	}

	private static void print(String s) {
		System.out.print(s);
	}

}
