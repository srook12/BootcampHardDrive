package examples.rmi;

import java.rmi.server.*;
import java.rmi.*;

public class AccountImpl extends UnicastRemoteObject
  implements Account {
    private double balance = 0.0;
    private String name = "";

    public AccountImpl(String aName)
      throws RemoteException {
        name = aName;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public double getBalance()
      throws RemoteException {
        return balance;
    }

    public void withdraw(double amt)
      throws RemoteException {
        if (amt > balance)
            throw new RemoteException();
        balance -= amt;
    }

    public void deposit(double amt)
      throws RemoteException {
        balance += amt;
    }

    public void transfer(double amt, Account src)
      throws RemoteException {
        src.withdraw(amt);
        this.deposit(amt);
    }
}