package examples.regex;

import java.io.*;
import java.util.regex.*;

public class RegExTester2 {
    private static BufferedReader kb =
        new BufferedReader(
            new InputStreamReader(System.in));

    public static void main(String[] args) {

        Pattern p = null;
        Matcher m = null;
        boolean found = false;
        String prompt1 = "Enter your regex: ";
        String prompt2 = "Enter String to search: ";
        while (true) {
            p = Pattern.compile(prompt(prompt1));
            m = p.matcher(prompt(prompt2));
            found = false;
            while (m.find()) {
                print("I found the text ");
                print(m.group());
                print(" starting at index ");
                print("" + m.start());
                print(" and ending at index ");
                print("" + m.end() + "\n");
                found = true;
            }
            if(!found){
                print("No match found.\n");
            }
        }
    }
    private static String prompt(String s){
        String userText = null;
        try{
            print(s);
            userText = kb.readLine();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return userText;
    }
    private static void print(String s){
	System.out.print(s);
    }

}
