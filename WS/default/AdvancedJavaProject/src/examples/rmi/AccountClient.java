package examples.rmi;

import java.net.URL;
import java.rmi.*;
import java.rmi.registry.*;

public class AccountClient {
    public static void main(String args[]) {
    	String host = "localhost";
    	if (args.length > 0) { host = args[0]; }
        try {
	        String key = "java.security.policy";
	        Class c = AccountClient.class;
            URL u =c.getResource("policy.client");
	        String value = u.getPath();
	        System.setProperty(key, value);
            System.setSecurityManager(
            		new RMISecurityManager());
			Registry r =
              LocateRegistry.getRegistry(host, 1099);
            // Lookup Account objects
            Account act1 =
            	(Account) r.lookup("Alan");
            Account act2 =
            	(Account) r.lookup("Dave");

            showBalance(act1);
            showBalance(act2);

            // Make some deposits
            act1.deposit(200);
            act2.deposit(100);

            // Show results
            System.out.println("Deposit 200 & 100");
            showBalance(act1);
            showBalance(act2);

            // Do a transfer
            act2.transfer(10, act1);

            // Show results
            System.out.println("Transfer 10");
            showBalance(act1);
            showBalance(act2);
        } catch (Exception e){ e.printStackTrace(); }
    }

    public static void showBalance(Account acct)
      throws RemoteException {
        System.out.println("Balance for " +
        		acct.getName() + " is " +
                acct.getBalance());
    }
}
