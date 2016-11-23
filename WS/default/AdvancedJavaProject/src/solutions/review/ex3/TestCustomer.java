package solutions.review.ex3;

import solutions.review.ex2.Address;

public class TestCustomer {

    public static void main(String[] args) {
        Customer cust01 =
            new Customer("Sue", "Smith", "Main St.",
                    "Baltimore", "MD", "12345");
        Address a = new Address("345 Poplar Rd.",
                "Savannah", "GA", "21450");
        Customer cust02 = new Customer("Phil",
                "McDonald", a);
        System.out.println(cust01);
        System.out.println();
        System.out.println(cust02);
        System.out.println();
        cust01.setBalance(500.00);
        System.out.println(cust01.getBalance());
        cust01.updateBalance(-200.00);
        System.out.println(cust01.getBalance());
    }

}
