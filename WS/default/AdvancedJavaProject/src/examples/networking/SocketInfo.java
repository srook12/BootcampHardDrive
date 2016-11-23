package examples.networking;
import java.net.*;
import java.io.*;
public class SocketInfo {
    public static void main(String args[]) {
        try {
            Socket s = new Socket(args[0], 80);
            print("Connected:");
            print("To: " + s.getInetAddress());
            print("  on port  " + s.getPort());
            print("From " + s.getLocalAddress());
            print("  on port " + s.getLocalPort());
            s.close();
        } catch(UnknownHostException e) {
            print("Unknown Host: " + args[0]);
            e.printStackTrace();
        } catch(SocketException e) {
            print("SocketException: " + args[0]);
            e.printStackTrace();
        } catch(IOException e) {
            print("IOException:");
            System.out.println(e);
            e.printStackTrace();
        }
    }
    private static void print(String s){
        System.out.println(s);
    }
}