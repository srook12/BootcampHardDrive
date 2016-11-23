package solutions.networking.ex1;
import java.net.*;
import java.io.*;
import java.util.*;
public class DayTimeServer {
    public static void main(String args[]) {
        ServerSocket theServer = null;
        Socket clientSocket;
        int port = 2345;
        InetAddress ia = null;
        // Attempt to start the server
        // bound to the given port
        try{
            theServer = new ServerSocket(port);
            // Print info about the server
            ia = InetAddress.getLocalHost();
            String host = ia.getHostAddress();
            System.out.print("Server started on " +
                host+ "  Listening on port "+ port);
            // loop for each client
            while(true){
                // wait for a client to connect
                clientSocket = theServer.accept();
                // handle client in a helper method
                handleClient(clientSocket);
            } // proceed to next Client
        } catch(IOException ioe){
            ioe.printStackTrace();
            System.exit(1);
        }
    }
    // Helper method to handle client communications
    private static void handleClient(Socket cSocket){
        PrintStream toClient;
        String data;
        try{
            // Get Output
            toClient = new PrintStream(
            cSocket.getOutputStream());
            // write to Client
            toClient.println(new Date());
            toClient.close();
            cSocket.close();
        }catch(IOException ioe){
            String msg = "Connection lost";
            System.out.println(msg);
        }
    }
}