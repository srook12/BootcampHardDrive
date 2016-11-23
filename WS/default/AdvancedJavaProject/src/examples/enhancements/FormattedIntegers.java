package examples.enhancements;

public class FormattedIntegers {
    public static void main(String args[]){
        int x = 456;
        printf(" 1:" + "%d",x); // Decimal
        printf(" 2:" + "%o",x); // Octal
        printf(" 3:" + "%x",x); // Hex (lower)
        printf(" 4:" + "%X",x); // Hex (upper)
        printf(" 5:" + "%10d",x);
        printf(" 6:" + "%-10d",x);
        printf(" 7:" + "%010d",x);
        printf(" 8:" + "%(d",-x);
        printf(" 9:" + "%+d",x);
        printf("10:" + "%+d",-x);
    }
    public static void printf(String f, Object ...a){
        System.out.printf(f + "%n", a);
    }
}