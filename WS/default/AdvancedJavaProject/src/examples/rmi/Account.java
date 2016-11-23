package examples.rmi;

import java.rmi.*;

public interface Account extends Remote {
    public String getName() throws RemoteException;

    public double getBalance()
      throws RemoteException;

    public void withdraw(double amt)
      throws RemoteException;

    public void deposit(double amt)
      throws RemoteException;

    public void transfer(double amt, Account src)
      throws RemoteException;
}