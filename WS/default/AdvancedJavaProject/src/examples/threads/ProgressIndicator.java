package examples.threads;
public class ProgressIndicator extends Thread{
    public void run() {
        while(true){
            System.out.print('.');
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){
                break;
            }
        }
    }
}