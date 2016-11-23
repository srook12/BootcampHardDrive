package examples.enhancements;
import static java.lang.Math.ceil;
import static java.lang.Math.random;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class AccessStaticMembers2 {

    public static void main(String[] args) {
        //Generate a random number between 1 and 10
        int x = (int) ceil(random() * 10);
        System.out.println("Random Number:" + x);
        
        //Calculate area of circle with radius of 4
        int radius = 4;
        double area = PI * pow(radius, 2);
        System.out.println("Area:" + area);
    }
}