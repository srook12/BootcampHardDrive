package solutions.review.ex2;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    
    public Address(String street, String city,
            String state, String zipcode) {
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
        sb.append(street).append('\n');
        sb.append(city).append(", ");
        sb.append(state).append(' ').append(zipCode);
        return sb.toString();
    }
}