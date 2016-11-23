package examples.collections;
import java.util.*;

public class FractionTest2 {
    public static void main(String a[]) {
        Fraction[] f = { new Fraction(-2, 3), 
           new Fraction(1, 10), new Fraction(-4, 5),
           new Fraction(1, 50), new Fraction(2, 3)};
        
        //Same as previous code
        //  relies on natural ordering and only
        //  works because Fraction implements the
        //  Comparable interface
        Arrays.sort(f);
        System.out.println(Arrays.toString(f));
        
        // Now sort the array from high to low
        //   requires second parameter to be an
        //   object that implements Comparator
        SortOrderEnum hl = SortOrderEnum.HIGH_TO_LOW;
        Arrays.sort(f,new FractionComparator(hl));
        System.out.println(Arrays.toString(f));
        
        // Now sort the array from low to high
        //   also using a comparator
        SortOrderEnum lh = SortOrderEnum.LOW_TO_HIGH;
        Arrays.sort(f, new FractionComparator(lh));
        System.out.println(Arrays.toString(f));
    }
}