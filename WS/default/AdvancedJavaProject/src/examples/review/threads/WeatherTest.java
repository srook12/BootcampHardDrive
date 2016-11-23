package examples.review.threads;

public class WeatherTest {

    public static void main(String notused[]) {
        WeatherBroadcast ws = new WeatherBroadcast();
        ws.setDaemon(true);
        ws.addListener(new SampleListener1());
        ws.addListener(new SampleListener2());
        ws.start();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}