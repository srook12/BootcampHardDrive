package examples.review;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class IOExample {
   
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        String theLine;
        Date d;
        String filePath = "src/examples/review/";
        String fileName = filePath + "dates.txt";
        String output = filePath + "output.txt";
        try {
            FileReader fr =
                new FileReader(fileName);
            br = new BufferedReader(fr);
            pw = new PrintWriter(output);
            while((theLine = br.readLine()) != null){
                d = parseAsDate(theLine);
                printDate(pw, d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOCleanupUtils.cleanup(br);
            IOCleanupUtils.cleanup(pw);
        }
    }
    
    final static SimpleDateFormat sdf1 =
        new SimpleDateFormat("MM/dd/yyyy");
    final static SimpleDateFormat sdf2 = 
        new SimpleDateFormat("EEEE");
    
    public static Date parseAsDate(String text){
        String s [] = text.split("/");
        int m = Integer.parseInt(s[0]) - 1;
        int d = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);
        GregorianCalendar gc = 
            new GregorianCalendar(y, m, d);
        return gc.getTime();
    }
    
    public static void printDate(PrintWriter pw,
                                 Date d){
        pw.print(sdf1.format(d));
        pw.print(" is a ");
        pw.println(sdf2.format(d));
    }
}