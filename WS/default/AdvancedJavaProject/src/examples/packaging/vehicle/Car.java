package examples.packaging.vehicle;
public class Car {
    private String make, model;
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
    public String toString() {
        return make + " " + model;
    }
}