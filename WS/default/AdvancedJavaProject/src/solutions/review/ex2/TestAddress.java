package solutions.review.ex2;

public class TestAddress {

    public static void main(String[] args) {
        Address a = new Address("7150 Riverwood Dr",
                        "Columbia", "MD", "20746");
        System.out.println(a.getStreet());
        System.out.println(a);
    }
}