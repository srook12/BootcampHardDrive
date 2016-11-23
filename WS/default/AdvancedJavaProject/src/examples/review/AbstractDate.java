package examples.review;
public abstract class AbstractDate{

    public boolean isLeapYear() {
        int y = getYear();
        boolean success = false;
        if(y % 400 == 0 ||
            ((y % 4 == 0) && (y % 100 != 0)))
            success =  true;
        return success;
    }
    public abstract int getDay();
    public abstract int getMonth();
    public abstract int getYear();
}