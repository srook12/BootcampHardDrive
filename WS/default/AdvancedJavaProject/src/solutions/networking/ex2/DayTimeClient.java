package solutions.networking.ex2;
import java.net.*;
import java.io.*;
import java.util.*;
public class DayTimeClient {
    public static void main(String args[]) {
        String host = "localhost";
        try {
            if(args.length > 0)
                host = args[0];
            Socket s = new Socket(host, 2345);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            System.out.println("Time at " + host + " is");
            Date d = (Date) ois.readObject();
            System.out.println(d);
            ois.close();
            s.close();
        }catch(IOException e) {
            System.out.println(e);
        }catch(ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        }
    }
}