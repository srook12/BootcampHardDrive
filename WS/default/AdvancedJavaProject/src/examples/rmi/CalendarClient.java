package examples.rmi;

import java.rmi.registry.*;
import java.util.Calendar;

public class CalendarClient {

    public static void main(String args[]) {
        Calendar c = null;
        CalendarTask remoteObj;
        String host = "10.24.0.109";
        if(args.length == 1)
            host = args[0];
        try {
            Registry r =
              LocateRegistry.getRegistry(host, 1099);
            Object o = r.lookup("TheCalendar");
            remoteObj = (CalendarTask) o;
            c = remoteObj.getDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("%tc", c);
    }
}