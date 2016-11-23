package examples.threads;
public class MyThread extends Thread {
    public MyThread(String s) {
        super(s);
    }
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println(getName() + " " + i);
        }
    }
    public static void main(String a[]) {
        MyThread t;
        t = new MyThread("Thread A");
        t.start();
        t = new MyThread("Thread B");
        t.start();
        for (int i = 0; i < 5; i++)
          System.out.println("MainThread " + i);
    }
}