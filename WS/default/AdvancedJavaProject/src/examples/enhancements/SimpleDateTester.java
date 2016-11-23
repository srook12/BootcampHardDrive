package examples.enhancements;

public class SimpleDateTester {

    public static void main(String[] args) {
        print(new SimpleDate1());
        print(new SimpleDate1(17));
        print(new SimpleDate1(3, 17));
        print(new SimpleDate1(3,17,2007));
        print("--------------------------------");
        print(new SimpleDate2());
        print(new SimpleDate2(17));
        print(new SimpleDate2(3, 17));
        print(new SimpleDate2(3,17,2007));
    }

    private static void print(Object o){
        System.out.println(o);
    }
}