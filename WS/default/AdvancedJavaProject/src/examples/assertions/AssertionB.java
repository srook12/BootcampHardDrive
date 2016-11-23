package examples.assertions;

public class AssertionB {
    public static void main(String[] args) {
        int d = (int) Math.ceil((Math.random() * 10));
        //Assert that the value is from 1 to 6
        assert d >= 1 && d <= 6 : "Rand:" + d;
        System.out.println("AssertB results:" + d);
        AssertionA.main(args);
    }
}