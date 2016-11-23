package solutions.rmi.ex1;
import java.rmi.*;

public interface MathServices2 extends java.rmi.Remote
{
    public double sqroot(double value) throws RemoteException;
    public double square(double value) throws RemoteException;
}
