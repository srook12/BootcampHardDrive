package examples.enhancements;

public class AccessStaticMembers1 {

    public static void main(String[] args) {
        //Generate a random number between 1 and 10
        int x = (int) Math.ceil(Math.random() * 10);
        System.out.println("Random Number:" + x);
        
        //Calculate area of circle with radius of 4
        int radius = 4;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area:" + area);
    }
}