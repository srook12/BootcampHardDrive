package examples.collections;
import java.util.*;

public class ConcurrentModificationProblem {
    public static void main(String[] args) {
        // Build ArrayList with an initial capacity
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(new String("Java"));
        arrayList.add(new String("Perl"));
        arrayList.add(new String("C++"));
        
        Iterator iterA = arrayList.iterator();
        Iterator iterB = arrayList.iterator();
        
        iterA.next();
        iterA.remove();
        
        // The following line will result in a 
        // ConcurrentModificationException at runtime
        iterB.next();
    }
}
