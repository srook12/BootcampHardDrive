package solutions.packaging.ex1;

/**
 * The <code>Customer</code> is a <code>Person</code>
 * with an address, an account balance and an internally
 * generated customer id.
 * 
 * @author /training/etc
 *
 */
public class Customer extends Person {
    /**
     * Used internally to generate the <tt>customerId</tt>
     */
    private static int idGenerator = 100000;
    /**
     * The <tt>Address</tt> of the <tt>Customer</tt>
     */
    protected Address address;
    /**
     * The <tt>Customer</tt> id.
     */
    protected int customerId;
    /**
     * The current balance of the <tt>Customer</tt>
     */
    protected double balance;
    
    /**
     * Creates an instance of <code>Customer</code>
     * with a given first name, last name and address.
     * @param first The first name of this <tt>Customer</tt>
     * @param last The last name of this <tt>Customer</tt>
     * @param a The <tt>Address</tt> of this <tt>Customer</tt>
     */
    public Customer(String first, String last,
            Address a) {
        super(first, last);
        address = a;
        customerId = idGenerator++;
    }
    
    /**
     * Creates an instance of <code>Customer</code>
     * with the given parameters.
     * @param first The first name of this <tt>Customer</tt>
     * @param last The last name of this <tt>Customer</tt>
     * @param street The street of this <tt>Customer</tt>
     * @param city The city of this <tt>Customer</tt>
     * @param state The state of this <tt>Customer</tt>
     * @param zipcode The zip code of this <tt>Customer</tt>
     */
    public Customer(String first, String last,
            String street, String city, String state,
            String zipcode) {
        this(first, last, new Address(street, city,
                state, zipcode));
    }
    
    /**
     * Returns the <tt>Address</tt> of this <tt>Customer</tt>
     * @return the <tt>Address</tt> of this <tt>Customer</tt>
     */
    public Address getAddress() {
        return address;
    }
    
    /**
     * Sets the address of this <tt>Customer</tt> to
     * the given <tt>address</tt>.
     * @param address the <tt>Address</tt> of this <tt>Customer</tt>
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    
    /**
     * Returns the balance available to the customer
     * @return the balance of the <tt>Customer</tt>
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Stes the balance to the given <tt>balance</tt>
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * Adds the given <tt>amount</tt> to the existing
     * balance and returns the new balance.
     * @param amount The amount to adjust the balance by.
     * @return the updated balance
     */
    public double updateBalance(double amount){
        return balance += amount;
    }
    
    /**
     * Returns the id of the <tt>Customer</tt>
     * @return the <tt>Customer</tt> id.
     */
    public int getCustomerId() {
        return customerId;
    }
    
    /** 
     * Returns a <code>String</code> representing the
     * <code>Customer</code> as
     * @return a <code>String</code> representing the 
     *    <code>Customer</code> info.
     */
    public String toString(){
        StringBuffer sb = new StringBuffer(128);
        sb.append("Customer ID:");
        sb.append(customerId).append('\n');
        sb.append(super.toString()).append('\n');
        sb.append(address.toString());
        return sb.toString();
    }
}