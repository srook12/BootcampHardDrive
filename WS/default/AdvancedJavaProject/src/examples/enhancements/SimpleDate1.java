package examples.enhancements;
import java.util.*;

public class SimpleDate1 {
    int month, day, year;
    private void helper(int varArgs []){
        Calendar now = new GregorianCalendar();
        month = now.get(Calendar.MONTH) + 1;
        day = now.get(Calendar.DAY_OF_MONTH);
        year = now.get(Calendar.YEAR);
        switch(varArgs.length){
            case 1:
                day   = varArgs[0];
                break;
            case 2:
                month = varArgs[0];
                day   = varArgs[1];
                break;
            case 3:
                month = varArgs[0];
                day   = varArgs[1];
                year  = varArgs[2];
                break;
        }
    }
    public SimpleDate1(){
        helper(new int [0]);
    }
    public SimpleDate1(int d){
        int x [] = {d};
        helper(x);
    }
    public SimpleDate1(int m, int d){
        int x [] = {m, d};
        helper(x);
    }
    public SimpleDate1(int m , int d, int y){
        int x [] = {m, d, y};
        helper(x);
    }
    public String toString(){
        return month + "/" + day + "/" + year;
    }
}