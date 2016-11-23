package examples.review.threads;
public class SampleListener2 implements
        TemperatureListener {
    int startTemp;
    boolean isValid = false;
    String msg = "There has been a 5\u00B0 change.";
    
    public void temperatureChanged(int temperature) {
        if(!isValid){
            startTemp = temperature;
            isValid = true;
        }
        int diff = Math.abs(temperature - startTemp);
        if( diff >= 5){
            System.out.println(msg);
            startTemp = temperature;
        }
    }
}