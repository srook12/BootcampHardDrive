package examples.enhancements;
import java.util.ArrayList;
import java.util.Vector;

public class AutoBoxing {

    public static void main(String[] args) {
        int numbers [] ={1 , 2, 3, 4, 5, 6, 7, 8, 9};
        useWrapperClasses(numbers);
        useAutoBoxing(numbers);
    }

    private static void useWrapperClasses(int n []){
        Vector v = new Vector();
        // populate list with numbers
        for(int i = 0; i < n.length; i++)
            v.add(new Integer(n[i]));
        //calculate sum of numbers in the list
        int sum = 0;
        for(int i = 0; i < v.size(); i++)
            sum += ((Integer) v.get(i)).intValue();
        System.out.println(sum);
    }

    private static void useAutoBoxing(int n []){
        Vector v = new Vector();
        // populate list with numbers
        for(int i = 0; i < n.length; i++)
            v.add(n[i]);
        //calculate sum of numbers in the list
        int sum = 0;
        int temp;
        for(int i = 0; i < v.size(); i++){
            temp = (Integer) v.get(i);
            sum += temp;
        }
        System.out.println(sum);
    }
}