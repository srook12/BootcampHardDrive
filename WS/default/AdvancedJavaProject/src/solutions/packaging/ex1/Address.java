package solutions.packaging.ex1;

/**
 * The <code>Address</code> class represents an address.
 * Where the address constists of a street, city, state and zip.
 * @author /training/etc
 *
 */
public class Address {
    /**
     * Represents the  address' street. e.g. "123 Main Street"
     */
    private String street;
    /**
     * Represents the  address' city. e.g. "Annapolis"
     */
    private String city;
    /**
     * Represents the address' state. e.g. "MD"
     */
    private String state;
    /**
     * Represents the address' zip code.
     * e.g. "12345" or "12345-1234"
     */
    private String zipCode;
    
    /**
     * Creates an instance of <code>Address</code>
     * with a given street, city, state, and zip code.
     * @param street e.g. "123 Main Street"
     * @param city e.g. "Annapolis"
     * @param state e.g. "MD"
     * @param zipcode e.g. "12345" or "12345-1234"
     */
    public Address(String street, String city,
            String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipcode;
    }

    /**
     * Returns the street portion of the <code>Address</code>.
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street of this <code>Address</code> to
     * the given value.
     * @param street The street e.g. "123 Main Street"
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns the city portion of the <code>Address</code>.
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of this <code>Address</code> to
     * the given value.
     * @param city e.g. "Annapolis"
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state portion of the <code>Address</code>.
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state of this <code>Address</code> to
     * the given value.
     * @param state e.g. "MD"
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the zip code portion of the <code>Address</code>.
     * @return the zip code
     */
    public String getZipcode() {
        return zipCode;
    }

    /**
     * Sets the zip code of this <code>Address</code> to
     * the given value.
     * @param zipcode e.g. "12345" or "12345-1234"
     */
    public void setZipcode(String zipcode) {
        this.zipCode = zipcode;
    }
    
    /** 
     * Returns a <code>String</code> representing the
     * <code>Address</code> as
     * <pre>
     * street
     * city, state zip
     * </pre>
     * @return a <code>String</code> representing the 
     *    name of this <code>Person</code>.
     */
    public String toString(){
        StringBuffer sb = new StringBuffer(64);
        sb.append(street).append('\n');
        sb.append(city).append(", ");
        sb.append(state).append(' ').append(zipCode);
        return sb.toString();
    }
}