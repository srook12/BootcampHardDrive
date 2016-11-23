package mywork.packaging.ex1;

import mywork.packaging.ex1.Person;
import mywork.packaging.ex1.Address;

/**
 * The {@code Customer} class is used to construct a representation of a Customer object. It extends the Person class.
 * 
 * @author SJR
 * @since Yesterday sometime
 *
 */

public class Customer extends Person {
	private Address address;
	
	/**
	 * A static variable that generates a unique id for a Customer object
	 */
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
	
	/**
	 * Reflects the Customer object's balance after being charged
	 * @param amount The amount charged for the purchase
	 */
	public void charge(double amount) {
		balance += amount;
	}

	public String toString() {
		return super.toString() + "\n" + address + "\n" + "With id: " + id + "\nWith balance: $" + balance;
	}
}
