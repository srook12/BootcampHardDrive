package solutions.threads.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandlerThread extends Thread {
	Socket cSocket;
	
	public ClientHandlerThread(Socket cSocket){
		this.cSocket = cSocket;
	}
	
	
	@Override
	public void run() {
		handleClient();
	}
    private void handleClient(){
        PrintStream toClient;
        BufferedReader fromClient;
        String data;
        try{
            // Get Input and Output
            fromClient = new BufferedReader(
                new InputStreamReader(
                    cSocket.getInputStream()));
            toClient = new PrintStream(
                cSocket.getOutputStream());
            while(true){
                // read from Client
                data = fromClient.readLine();
                if(data == null) break;
                data = data.toUpperCase();
                // write to Client
                toClient.println(data);
            }
            fromClient.close();
            toClient.close();
            cSocket.close();
        }catch(IOException ioe){
            String msg = "Connection lost";
            System.out.println(msg);
        }
    }
}
