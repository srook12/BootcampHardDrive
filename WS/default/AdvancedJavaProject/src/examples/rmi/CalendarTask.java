package examples.rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;
public interface CalendarTask extends Remote {
    Calendar getDate() throws RemoteException;
}