package examples.enhancements;

public class FormattedFloatingPoints {
    public static void main(String args[]){
        double x = 1234567.0 + 2.0/3.0;
        printf(" 1:" + "%f",x);
        printf(" 2:" + "%.9f",x);
        printf(" 3:" + "%.3f",x);
        printf(" 4:" + "%15.3f",x);
        printf(" 5:" + "%015.3f",x);
        printf(" 6:" + "%,f",x);
        printf(" 7:" + "%e",x);
        printf(" 8:" + "%.10e",x);
        printf(" 9:" + "%g",x);
        printf("10:" + "%.9g",x);
    }
    public static void printf(String f, Object ...a){
        System.out.printf(f + "%n", a);
    }
}