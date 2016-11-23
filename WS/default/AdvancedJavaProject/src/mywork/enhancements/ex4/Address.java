package mywork.enhancements.ex4;

public class Address {		
	private String street;
	private String city;
	private String state;
	private String zip;
	private EnumeratedAddress addressType;
	
	public Address(String street, String city, String state, String zip, String addressType) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		switch(addressType) {
			case "HOME":
				this.addressType = EnumeratedAddress.HOME;
				break;
			case "WORK":
				this.addressType = EnumeratedAddress.WORK;
				break;
		}
	}
	
	public String getAddressType() {
		return addressType.getAddressType();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

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
		return street + "\n" + city + ", " + state + " " + zip + "\nThis is a " + this.getAddressType() + " address.";
	}

}
