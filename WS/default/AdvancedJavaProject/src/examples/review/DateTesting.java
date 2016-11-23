package examples.review;

public class DateTesting {

    public static void main(String[] args) {
        showDateInfo(new SimpleDate(1, 31, 2008));
        showDateInfo(new Today());
    }
    public static void showDateInfo(AbstractDate d){
        System.out.print(d.getMonth());
        System.out.print("/");
        System.out.print(d.getDay());
        System.out.print("/");
        System.out.println(d.getYear());
    }
}