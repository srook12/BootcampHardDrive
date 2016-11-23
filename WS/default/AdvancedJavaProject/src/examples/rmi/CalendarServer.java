package examples.rmi;
import java.rmi.registry.*;

public class CalendarServer {

    public static void main(String args[]) {
        System.out.println("Starting server...");
        // Start RMI registry service and bind
        // object to the registry
        try {
            Registry r =
                LocateRegistry.createRegistry(1099);
            r.rebind("TheCalendar",
                    new CalendarImpl());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Server ready");
    }
}