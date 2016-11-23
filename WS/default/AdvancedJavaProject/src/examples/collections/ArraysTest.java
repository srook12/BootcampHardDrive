package examples.collections;
import java.util.*;

public class ArraysTest {
    public static void main(String[] args) {
        int[] a = { 88, 17, -10, 34, 27, 0, -2 };
        int[] find = { -10, -1, 0, 1, 34, 100 };
        System.out.print("Before sort: ");
        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.print("After sort: ");
        System.out.println(Arrays.toString(a));
        
        System.out.print("Looking For: ");
        System.out.println(Arrays.toString(find));
        for (int val : find)
            search(a, val);
    }
    
    private static void search(int[] arr, int n) {
        int pos = Arrays.binarySearch(arr, n);
        String msg;
        if (pos >= 0) {
            msg = "Found " + n + ", position " + pos;
        } else {
            int insertionPoint = -(pos + 1);
            if (insertionPoint == arr.length) {
                msg = "Append " + n + " to end";
            } else {
                msg = "Insert " + n + " at position "
                        + insertionPoint;
            }
        }
        System.out.println(msg);
    }
}