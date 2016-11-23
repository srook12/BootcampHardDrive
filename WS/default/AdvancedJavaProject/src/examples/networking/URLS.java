package examples.networking;
import java.net.*;
public class URLS {
    public static void main(String args[]) {
        try {
            URL u = new URL("http", args[0], 80,
                            "/index.html");
            System.out.println(u);
            print("Prot: " + u.getProtocol());
            print("Host: " + u.getHost());
            print("Port: " + u.getPort());
            print("Ref:  " + u.getRef());
            print("File: " + u.getFile());
        } catch(MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void print(String s){
        System.out.println(s);
    }
}