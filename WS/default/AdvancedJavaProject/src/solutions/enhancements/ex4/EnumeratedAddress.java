package solutions.enhancements.ex4;

public class EnumeratedAddress {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private AddressEnum type;
    
    public EnumeratedAddress(AddressEnum type, 
            String street, String city,
            String state, String zipcode) {
        this.type = type;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipcode;
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
        return zipCode;
    }

    public void setZipcode(String zipcode) {
        this.zipCode = zipcode;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer(64);
        sb.append("Type:").append(type).append('\n');
        sb.append(street).append('\n');
        sb.append(city).append(", ");
        sb.append(state).append(' ').append(zipCode);
        return sb.toString();
    }

    public void setType(AddressEnum type) {
        this.type = type;
    }

    public AddressEnum getType() {
        return type;
    }
}