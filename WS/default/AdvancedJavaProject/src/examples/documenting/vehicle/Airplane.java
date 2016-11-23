package examples.documenting.vehicle;
import examples.packaging.vehicle.options.DVDPlayer;
public class Airplane {
    private DVDPlayer dvd = new DVDPlayer();
    public void startInFlightEntertainment(){
        dvd.insert("Airplane II");
        dvd.play();
    }
}