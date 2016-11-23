package examples.rmi;

import java.io.IOException;
import java.net.InetAddress;
import java.rmi.registry.*;

public class AccountServer {
    private static String buildCommandLine(){
        String jcp = "java.class.path";
        StringBuffer sb = new StringBuffer();
        sb.append('"');
        sb.append(System.getProperty(jcp));
        sb.append('"');
        String classpath = sb.toString();
        sb.setLength(0);
        sb.append("rmic -d ").append(classpath);
        sb.append(" -classpath ").append(classpath);
        sb.append(" examples.rmi.AccountImpl");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String args[]) {
        // exeucte rmic as an external process
        Process p = null;
        try {
            String command = buildCommandLine();
            p = Runtime.getRuntime().exec(command);
            p.waitFor(); // wait for completion
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        try {
            String key = "java.rmi.server.codebase";
            InetAddress server =
                InetAddress.getLocalHost();
            String address = server.getHostAddress();
            String value =
                "http://" + address + ":8080/";
            System.setProperty(key, value);
            //Start the StubServer
            Thread t = new StubServer();
            t.start();
            // Create registry service
            Registry reg =
                LocateRegistry.createRegistry(1099);
            // Create some Accounts
            AccountImpl acct1 =
            	new AccountImpl("Alan");
            AccountImpl acct2 =
            	new AccountImpl("Dave");

            // Register with the naming registry.
            reg.rebind("Alan", acct1);
            reg.rebind("Dave", acct2);

            System.out.println("Accts registered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}