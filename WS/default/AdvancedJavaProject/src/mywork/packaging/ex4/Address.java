package mywork.packaging.ex4;

/**
 * The {@code Address} class is used to construct a representation of an Address object
 * 
 * @author SJR
 * @since Yesterday
 *
 */

public class Address {
	/**
	 * The house number and street name of the address
	 * 
	 * @deprecated
	 */
	private String street;
	private String city;
	private String state;
	private String zip;
	
	/**
	 * Constructor for creating an Address object
	 * 
	 * @param street
	 * @param city
	 * @param state Represents one of the 50 United States of an Address object
	 * @param zip Represents the 5 digit postal code of an Address object
	 */
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	/**
	 * @deprecated Do not use
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Accessor that returns the city portion of an Address object
	 * @return The city portion of an Address object
	 */
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String toString() {
		return street + "\n" + city + ", " + state + " " + zip;
	}

}
