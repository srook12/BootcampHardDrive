package mywork.networking.ex1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket;
		int port = 1212;
		InetAddress ia = null;
		Date d;
		PrintStream toClient;
		
		try {
			serverSocket = new ServerSocket(port);
			ia = InetAddress.getLocalHost();
			
			while(true) {
				clientSocket = serverSocket.accept();
				d = new Date();
				toClient = new PrintStream(clientSocket.getOutputStream());
				toClient.println(d.toString());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(12);
		}
	}
}
