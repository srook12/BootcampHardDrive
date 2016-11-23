package examples.generics;
import java.util.*;

public class WithGenerics {
    public static int length(Collection<String> c) {
        Iterator<String> i = c.iterator();
        int sum = 0;
        while(i.hasNext()){
            sum += i.next().length();
        }
        return sum;
    }
    
    public static int length1(Collection<String> c) {  
        int sum = 0;
     
        for(String s : c)
        	sum += s.length();
        return sum;
    }
}