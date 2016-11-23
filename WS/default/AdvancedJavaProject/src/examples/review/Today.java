package examples.review;
import java.util.Calendar;

public class Today extends AbstractDate {
    public int getDay() {
       Calendar c = Calendar.getInstance();
       return c.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH) + 1;
    }

    public int getYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }
}