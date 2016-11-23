package examples.collections;
import java.util.*;

public class ListUtils {
    
    // Use an Iterator to print all elements in List
    public static void outputList(List list){
        Iterator i = list.iterator();
        while (i.hasNext()) {
            print(i.next());
        }
    }
    
    // Find first occurence of an object in List
    public static void search(List list, Object obj){
        int index = list.indexOf(obj);
        if (index != -1) {
            print(obj + " found in pos:" + index);
        } else {
            print("Didn't find " + obj);
        }
    }
    
    // Helper method for printing an object
    private static void print(Object obj){
        System.out.println(obj);
    }
}