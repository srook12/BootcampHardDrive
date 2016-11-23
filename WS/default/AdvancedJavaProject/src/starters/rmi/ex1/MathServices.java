package starters.rmi.ex1;
import java.rmi.*;

public interface MathServices extends java.rmi.Remote
{
    public double square(double value) throws RemoteException;
    public double sqroot(double value) throws RemoteException;
}
