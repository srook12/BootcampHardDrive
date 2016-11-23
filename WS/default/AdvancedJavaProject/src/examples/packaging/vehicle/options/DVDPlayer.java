package examples.packaging.vehicle.options;
public class DVDPlayer {
    private String title;
    public void insert(String title){
        this.title = title;
    }
    public void play(){
        System.out.print(title + " is playing.");
    }
}