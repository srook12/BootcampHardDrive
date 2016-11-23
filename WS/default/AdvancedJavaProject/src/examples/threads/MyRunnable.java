package examples.threads;
public class MyRunnable implements Runnable {
    public MyRunnable() { }
    public void run() {
        String name =
            Thread.currentThread().getName();
        for (int i = 0; i < 5; i++)
            System.out.println(name + " " + i);
    }
    public static void main(String args[]) {
        Thread t;
        t = new Thread(new MyRunnable());
        t.start();
        t = new Thread(new MyRunnable());
        t.start();
        String name =
            Thread.currentThread().getName();
        for (int i = 0; i < 5; i++)
            System.out.println(name + " " + i);
    }
}