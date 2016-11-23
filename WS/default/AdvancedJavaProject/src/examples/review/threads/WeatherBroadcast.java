package examples.review.threads;
import java.util.*;

public class WeatherBroadcast extends Thread {
    private Vector listeners = new Vector();
    private int tmp = 70;

    public void addListener(TemperatureListener t){
        listeners.add(t);
    }

    public void run() {
        while (true){
            int direction = new Random().nextInt(2);
            int amount = new Random().nextInt(15);
            for (int i = 0; i < amount; i++) {
                if(direction == 0)
                    tmp++;
                else
                    tmp--;
                Enumeration e = listeners.elements();
                TemperatureListener listener;
                while(e.hasMoreElements()){
                   Object obj = e.nextElement();
                   listener =
                       (TemperatureListener) obj;
                   listener.temperatureChanged(tmp);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    //quietly ignore
                }
            }
        }
    }
}