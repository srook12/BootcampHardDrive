package examples.enhancements;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FormattedDates {
    public static void main(String args[]){
        // February 9, 2008 23:45:01
        Calendar c =
            new GregorianCalendar(2008,1,9,23,45,01);
        printf("%1$tb or %1$tB or %1$tm", c);
        printf("%1$ta or %1$tA", c);
        printf("%1$tH:%1$tM:%1$tS", c);
        printf("%1$tI:%1$tM:%1$tS %1$tp", c);
        printf("%tR", c);
        printf("%tT", c);
        printf("%tr", c);
        printf("%tD", c);
        printf("%tc", c);
    }
    public static void printf(String f, Object ...a){
        System.out.printf(f + "%n", a);
    }
}