package solutions.networking.ex1;
import java.net.*;
import java.io.*;
public class DayTimeClient {
    public static void main(String args[]) {
        String host = "localhost";
        try {
            if(args.length > 0)
                host = args[0];
            Socket s = new Socket(host, 2345);
            InputStream is = s.getInputStream();
            System.out.println("Time at " +
                                host + " is");
            int data;
            while((data = is.read()) != -1)
                System.out.print((char) data);
            is.close();
            s.close();
        }catch(IOException e) {
            System.out.println(e);
        }
    }
}