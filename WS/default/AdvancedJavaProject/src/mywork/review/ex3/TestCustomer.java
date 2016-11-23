package mywork.review.ex3;

import mywork.review.ex2.Address;

public class TestCustomer {

	public static void main(String[] args) {
		Customer c1 = new Customer("Jim", "Bean", "123 Main Street", "Baltimore", "MD", "11223");
		c1.charge(235.00);
		Customer c2 = new Customer("John", "Smith", new Address("12 Evil Way", "Boston", "Massachussetts", "23567"));
		c2.charge(373.25);
		c2.charge(10.99);
		Customer c3 = new Customer("Homer", "Simpson", "742 Evergreen Terrace", "Springfield", "?", "23456");
		c3.charge(1);
		c3.charge(754.85);
		c3.charge(1000);
		
		System.out.println(c1);
		System.out.println();
		System.out.println(c2);
		System.out.println();
		System.out.println(c3);
	}

}
