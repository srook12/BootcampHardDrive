package mywork.review.ex3;

import mywork.review.ex1.Person;
import mywork.review.ex2.Address;

public class Customer extends Person {
	private Address address;
	private static int generator = 100000;
	private int id;
	
	private double balance = 0.0;
	
	public Customer(String first, String last, Address a) {
		super(first, last);
		address = a;
		id = generator++;
	}
	
	public Customer(String first, String last, String street, String city, String state, String zip) {
		this(first, last, new Address(street, city, state, zip));
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void charge(double amount) {
		balance += amount;
	}

	public String toString() {
		return super.toString() + "\n" + address + "\n" + "With id: " + id + "\nWith balance: $" + balance;
	}
}
