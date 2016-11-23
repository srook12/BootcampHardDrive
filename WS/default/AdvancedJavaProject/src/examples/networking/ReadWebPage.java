package examples.networking;
import java.net.*;
import java.io.*;
public class ReadWebPage {
    public static void main(String args[]) {
        try {
            URL web = new URL("http://" + args[0]);
            InputStream  is = web.openStream();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(is));
            String text;
            while((text = br.readLine()) != null)
                System.out.println(text);
            br.close();
        } catch(MalformedURLException e)  {
            System.out.println("Malformed");
        } catch(IOException e) {
            System.out.println("IOException");
        }
    }
}