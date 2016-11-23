package examples.assertions;

public class AssertionA {
    public static void main(String[] args) {
        int d = (int) Math.ceil((Math.random() * 6));
        //Assert that the value is from 1 to 6
        assert d >= 1 && d <= 6;
        System.out.println("AssertA results:" + d);
    }
}