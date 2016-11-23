package examples.threads;
import java.io.*;
public class TimedDataEntry {
    public static void main(String args[])
      throws IOException{
        String str;
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        TimerThread timer;
        Thread t;
        while(true) {
            timer = new TimerThread(10);
            t = new Thread(timer);
            t.start();
            System.out.println("Enter a string: ");
            str = br.readLine();
            t.interrupt();
            System.out.println("You entered " + str);
        }
    }
}