package examples.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class EchoServer {
    public static void main(String args[]) {
        Selector selector = null;
        ServerSocketChannel sscServer = null;
        SocketChannel socketChannel = null;
        
        ServerSocket theServer = null;
        Socket clientSocket = null;
        int port = 2345;
        InetAddress ia = null;
        // Attempt to start the server
        // bound to the given port
        try{
            selector = Selector.open();
            sscServer = ServerSocketChannel.open();
            sscServer.configureBlocking(false);
            
            sscServer.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
            // Print info about the server
            ia = InetAddress.getLocalHost();
            String host = ia.getHostAddress();
            System.out.print("Server started on " +
                host+ "  Listening on port "+ port);
            // loop for each client
            SelectionKey acceptKey = sscServer.register(selector, SelectionKey.OP_ACCEPT);
            while(acceptKey.selector().select() > 0){
        	Set readyKeys = selector.selectedKeys();
        	Iterator it = readyKeys.iterator();
        	while(it.hasNext()){
        	    SelectionKey key = (SelectionKey) it.next();
        	    it.remove();
        	}

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
