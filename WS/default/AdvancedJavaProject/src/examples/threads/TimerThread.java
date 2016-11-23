package examples.threads;
public class TimerThread implements Runnable {
    int secs;
    public TimerThread(int s) {
            secs = s;
    }
    public void run() {
        System.out.print("Timer set for ");
        System.out.println(secs + " seconds.");
        try {
            Thread.sleep(secs * 1000);
        }
        catch(InterruptedException e) {
            System.out.print("Timer Thread ");
            System.out.println("Interrupted");
            return;
        }
        System.out.println("You are too slow ...");
        System.exit(0);
    }
}