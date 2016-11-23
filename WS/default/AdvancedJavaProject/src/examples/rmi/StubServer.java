package examples.rmi;

import java.io.*;
import java.net.*;

public class StubServer extends Thread {
	
    static byte[] hdrNotFound =
        "HTTP/1.0 404 Not Found\n\n".getBytes();
    static byte[] notFound =
        "<html>Resource Not Found</html>".getBytes();
    static byte[] hdrOK =
        "HTTP/1.0 200 OK\n\n".getBytes();
    static byte[] testResponse =
        "<html>Server operational</html>".getBytes();

    public void run() {
        ServerSocket theServer = null;
        Socket clientSocket;
        // Attempt to start the server
        try {
            theServer = new ServerSocket(8080);
            while (true) {
                clientSocket = theServer.accept();
                handleClient(clientSocket);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(1);
        }
    }

    private void handleClient(Socket cSocket) {
        OutputStream toClient = null;
        BufferedReader fromClient = null;
        try {
            // Get Input and Output
            fromClient = new BufferedReader(
            		new InputStreamReader(cSocket
                    .getInputStream()));
            toClient = cSocket.getOutputStream();
            // read from Client
            String theLine = fromClient.readLine();
            String request = theLine.split(" ")[1];
            System.out.println("StubServer Request:"
            		            + theLine);
            if (request.equals("/")) {
                toClient.write(hdrOK);
                toClient.write(testResponse);
            } else {
                processStub(request, toClient);
            }

            fromClient.close();
            toClient.close();
            cSocket.close();
        } catch (IOException ioe) {
            String msg = "Connection lost";
            System.out.println(msg);
        }
    }
    private void processStub(String req,
            OutputStream toClient){
        InputStream is =
            this.getClass().getResourceAsStream(req);
        
        byte[] bufferedStub = null;
        try {
            if (is != null) {
                int size = is.available();
                bufferedStub = new byte[size];
                is.read(bufferedStub);
                is.close();
                toClient.write(hdrOK);
                toClient.write(bufferedStub);
            } else {
                toClient.write(hdrNotFound);
                toClient.write(notFound);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}