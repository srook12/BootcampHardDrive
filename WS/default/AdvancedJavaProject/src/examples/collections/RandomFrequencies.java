package examples.collections;
import java.util.*;

public class RandomFrequencies {

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            a.add(r.nextInt(50));
        }
        
        // Copy ArrayList of random numbers into
        // a HashSet in order to remove duplicates,
        // leaving on the numbers that actually got
        // generated
        HashSet uniqueSet = new HashSet(a);
        
        // Create a Treemap whose keys will be
        // sorted from high to low
        // (opposite of normal)
        TreeMap tm =
            new TreeMap(Collections.reverseOrder());
        
        // Calculate the frequency of each number
        // and map it as value to number 
        for(Object num:uniqueSet){
            int frq = Collections.frequency(a, num);
            tm.put(num, frq);
        }
        
        // Display contents of TreeMap
        System.out.println("Number\tFrequency");
        for(Object obj:tm.entrySet()){
            Map.Entry me = (Map.Entry) obj;
            System.out.print(me.getKey());
            System.out.print("\t");
            System.out.println(me.getValue());
        }
    }
}