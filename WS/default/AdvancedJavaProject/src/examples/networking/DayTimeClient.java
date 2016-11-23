package examples.networking;
import java.net.*;
import java.io.*;
public class DayTimeClient {
    public static void main(String args[]) {
        String host = "time.nist.gov";
        try {
            if(args.length > 0)
                host = args[0];
            Socket s = new Socket(host, 13);
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(is));
            System.out.println("Time at " +
                                host + " is");
            String data;
            while((data = br.readLine()) != null)
                System.out.println(data);
            br.close();
            s.close();
        }catch(IOException e) {
            System.out.println(e);
        }
    }
}