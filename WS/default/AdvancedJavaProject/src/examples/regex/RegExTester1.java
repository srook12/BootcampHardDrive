package examples.regex;
import java.io.*;

public class RegExTester1 {
    private static BufferedReader kb =
        new BufferedReader(
            new InputStreamReader(System.in));
    
    public static void main(String[] args) {
        String txt = null;
        String regex = null;
        boolean found = false;
        String response = null;
        while (true) {
            regex = prompt("Enter your regex: ");
            txt = prompt("Enter String to match: ");
            found = txt.matches(regex);
            response = "Match Found\n";
            if(!found)
                response ="No " + response;
            print(response);
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