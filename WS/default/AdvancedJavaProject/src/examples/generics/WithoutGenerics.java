package examples.generics;
import java.util.*;

public class WithoutGenerics {
    private static int length(Collection c) {
        Iterator i = c.iterator();
        int sum = 0;
        while(i.hasNext()){
            sum += ((String) i.next()).length();
        }
        return sum;
    }
}