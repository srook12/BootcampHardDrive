package examples.review.threads;

public class SampleListener1 implements
        TemperatureListener {
    public void temperatureChanged(int temperature) {
        System.out.print("Current Temperature is ");
        System.out.println(temperature + "\u00B0");
    }
}