package examples.networking;
import java.net.*;
import java.io.*;
import java.util.*;
public class ReadHeaders {
    public static void main(String argv[]) {
        try {
            URL u = new URL("http://" + argv[0]);
            URLConnection uc = u.openConnection();
            print("Content Type:" +
                uc.getContentType());
            print("Content Length:" +
                uc.getContentLength());
            print("Date:" + new Date(uc.getDate()));
            print("Last Modified:" +
                new Date(uc.getLastModified()));
        } catch(MalformedURLException e) {
            System.out.println("Malformed");
        } catch(IOException e) {
            System.out.println("IOException");
        }
    }
    private static void print(String s){
        System.out.println(s);
    }
}