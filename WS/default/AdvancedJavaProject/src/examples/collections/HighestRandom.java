package examples.collections;
import java.util.*;

public class HighestRandom {

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            a.add(r.nextInt(50));
        }
        Object obj = Collections.max(a);
        System.out.println("largest: " + obj);
        int freq = Collections.frequency(a, obj);
        System.out.println("frequency: " + freq);
    }
}