package examples.collections;
import java.util.*;

public class FractionTest1 {
    public static void main(String a[]) {
        Fraction[] f = { new Fraction(-2, 3), 
           new Fraction(1, 10), new Fraction(-4, 5),
           new Fraction(1, 50), new Fraction(2, 3)};
        Arrays.sort(f);
        System.out.println(Arrays.toString(f));
    }
}
