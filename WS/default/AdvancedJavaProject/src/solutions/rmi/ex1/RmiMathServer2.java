package solutions.rmi.ex1;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class RmiMathServer2
    extends UnicastRemoteObject
    implements MathServices2
{
    public RmiMathServer2(String sName) throws RemoteException
    {
        try
        {
            Naming.rebind(sName, this);
        } catch (Exception e)
        {
            throw new RemoteException("Reason: " + e.toString());
        }
    }

    public double sqroot(double value) throws RemoteException
    {
        return Math.sqrt(value);
    }

    public double square(double value) throws RemoteException
    {
        return value * value;
    }

    public static void main(String[] args)
    {
        //System.setSecurityManager(new RMISecurityManager());
        try
        {
            new RmiMathServer2("MathServer");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
