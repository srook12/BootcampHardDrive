package examples.assertions;

public class AssertionD {
    public static void main(String[] args) {
        int d = (int) Math.ceil((Math.random() * 10));
        //Assert that the value is from 1 to 6
        if(d >= 1 && d <= 6)
            throw new AssertionError("Rand:" + d);
        System.out.println("AssertD results:" + d);
        AssertionC.main(args);
    }
}