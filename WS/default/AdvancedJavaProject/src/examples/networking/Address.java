package examples.networking;
import java.net.*;
public class Address {
    public static void main(String args[])  {
        try {
            print("Remote Host:");
            InetAddress remote =
                InetAddress.getByName(args[0]);
            getInfo(remote);
            print("Local Host:");
            InetAddress local =
                InetAddress.getLocalHost();
            getInfo(local);
        } catch(UnknownHostException e) {
            print("Unknown Host: " + e.getMessage());
        }
    }
    private static void getInfo(InetAddress ia){
        print("  HostName: " +
              ia.getHostName());
        print("  HostAddress: "
              + ia.getHostAddress());
        print("  CanonicalHostname: " +
              ia.getCanonicalHostName());
        getRawIP(ia);
        System.out.println();
    }
    private static void getRawIP(InetAddress ia){
        byte [] b = ia.getAddress();
        System.out.print("  ");
        for (int i = 0; i < b.length; i++) {
            int each = b[i] < 0 ? b[i] + 256 : b[i];
            System.out.print(each + " ");
        }
        System.out.println();
    }
    private static void print(String s){
        System.out.println(s);
    }
}