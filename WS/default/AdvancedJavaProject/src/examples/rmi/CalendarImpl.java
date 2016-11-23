package examples.rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

public class CalendarImpl extends UnicastRemoteObject
        implements CalendarTask {
    
    private int counter = 1;

    public CalendarImpl() throws RemoteException {}

    public Calendar getDate() throws RemoteException{
        System.out.print("Method called on server:");
        System.out.println("counter = " + counter++);
        return Calendar.getInstance();
    }
}