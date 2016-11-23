package examples.collections;

import java.util.Comparator;

public class FractionComparator implements Comparator
{
    private SortOrderEnum order;
    public FractionComparator(SortOrderEnum so){
        order = so;
    }
    public int compare(Object obj1, Object obj2) {
        Fraction f1 = (Fraction) obj1;
        Fraction f2 = (Fraction) obj2;
        if(order == SortOrderEnum.LOW_TO_HIGH){
            return f1.compareTo(f2);
        }else{
            return f2.compareTo(f1);
        }
    }
}