package solutions.regex.ex5;
import java.util.UnknownFormatConversionException;
public class EnumeratedAddress {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private AddressType type;
	private final String regex =
		"(\\d{5})|(\\d{5}-\\d{4})";
	public EnumeratedAddress(String street, String city,
			String state, String zipcode, AddressType type) {
		checkZipCode();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.type = type;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		checkZipCode();
		this.zipcode = zipcode;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer(128);
		sb.append(type).append('\n');
		sb.append(street).append('\n');
		sb.append(city).append(", ").append(state);
		sb.append("  ").append(zipcode);
		return sb.toString();
	}
	public AddressType getType() {
		return type;
	}
	public void setType(AddressType type) {
		this.type = type;
	}
	private void checkZipCode(){
		if(!zipcode.matches(regex)){
			String msg = "Zipcode not in format of " +
			"##### or #####-####";
			throw new UnknownFormatConversionException(msg);
		}
	}
}
