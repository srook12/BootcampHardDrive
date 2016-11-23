package examples.collections;
import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        // Build ArrayList with an initial capacity
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(new String("Java"));
        arrayList.add(new String("Perl"));
        arrayList.add(new String("C++"));
        
        // Retrieve by index
        print(arrayList.get(2) + " found in pos:2");
        
        // Search for an element in List
        print("\nSearch Results:");
        ListUtils.search(arrayList, "Perl");
        
        // Traverse using an iterator
        print("\nIterator Results...");
        ListUtils.outputList(arrayList);
        
        // Build LinkedList from ArrayList
        LinkedList list = new LinkedList(arrayList);
        
        // Manipulate contents of the LinkedList
        list.remove("Perl");
        list.add("JavaScript");

        // Traverse using an iterator
        print("\nIterator Results...");
        ListUtils.outputList(list);

        // Traverse in reverse order
        ListIterator listIter =
            list.listIterator(list.size());
        print("\nIterating in reverse...");
        while (listIter.hasPrevious()) {
            print(listIter.previous());
        }
        
        // Traverse using enhanced for loop
        print("\nFor Loop Results...");
        for(Object obj:list)
            print(obj);
    }

    // Helper method for printing an object
    private static void print(Object obj){
        System.out.println(obj);
    }
}