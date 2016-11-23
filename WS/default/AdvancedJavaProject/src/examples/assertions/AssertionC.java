package examples.assertions;

public class AssertionC {
    public static void main(String[] args) {
        int d = (int) Math.ceil((Math.random() * 6));
        //Assert that the value is from 1 to 6
        if(d >= 1 && d <= 6)
            throw new AssertionError();
        System.out.println("AssertC results:" + d);
    }
}