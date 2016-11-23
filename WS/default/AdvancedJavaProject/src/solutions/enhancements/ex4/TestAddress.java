package solutions.enhancements.ex4;

public class TestAddress {

    public static void main(String[] args) {
        EnumeratedAddress a = new EnumeratedAddress(
                AddressEnum.WORK,
                "7150 Riverwood Dr",
                 "Columbia", "MD", "20746");
        System.out.println(a.getStreet());
        System.out.println(a);
    }
}