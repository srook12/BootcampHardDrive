package examples.io;

import java.io.Console;
import java.util.Arrays;

public class ConsoleTest {
    public static void main(String[] args) {
        Console c = System.console();
        if(c == null){
            System.err.println("No Console...");
            System.exit(1);
        }
        String name = c.readLine("User Name:");
        char [] pwd = c.readPassword("Password:");
        //Code to process password would be here
        
        //Manually zero out password array
        Arrays.fill(pwd, ' ');
    }
}