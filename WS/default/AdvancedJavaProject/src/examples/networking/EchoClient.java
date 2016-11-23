package examples.networking;
import java.net.*;
import java.io.*;
public class EchoClient {
    public static void main(String args[]) {
        Socket con = null;
        PrintStream toServer;
        BufferedReader fromServer, fromKB;
        String data;
        int port = 2345;
        String host = "localhost";
        if(args.length > 0)
            host = args[0];
        try{
            // Attempt to connect to server
            con = new Socket(host, port);
        } catch(IOException ioe){
            // No use in continuing
            String msg = "Unable to connect";
            System.out.println(msg);
            ioe.printStackTrace();
            System.exit(1);
        }
        try{
            // get Input(s) and Output
            fromKB = new BufferedReader(
                new InputStreamReader(
                    System.in));
            fromServer = new BufferedReader(
                new InputStreamReader(
                    con.getInputStream()));
            toServer = new PrintStream(
                con.getOutputStream());
            // communicate with the server
            String prompt = "Enter Data:\n" +
                "Entering just the word QUIT will " +
                "Close the connection.";
            System.out.println(prompt);
            while(true){
                // read from keyboard
                data = fromKB.readLine();
                if(data.equals("QUIT")) break;
                // write data to server
                toServer.println(data);
                // read response from server
                System.out.println(
                    fromServer.readLine());
            }
            // close resources
            fromServer.close();
            toServer.close();
            con.close();
        }catch(IOException ioe){
            String msg = "Connection lost";
            System.out.println(msg);
        }
    }
}