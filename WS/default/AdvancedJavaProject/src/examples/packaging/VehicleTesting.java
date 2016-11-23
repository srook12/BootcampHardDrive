package examples.packaging;
import examples.packaging.vehicle.Airplane;
import examples.packaging.vehicle.Car;
import examples.packaging.vehicle.options.DVDPlayer;
public class VehicleTesting {
    public static void main(String[] args) {
        System.out.println(new Car("Honda", "Fit"));
        Airplane a = new Airplane();
        a.startInFlightEntertainment();
        DVDPlayer player = new DVDPlayer();
        player.insert("Gone with the Wind");
        player.play();
    }
}