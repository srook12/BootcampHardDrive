package starters.packaging.ex1;

public class Customer extends Person {
    private static int idGenerator = 100000;
    protected Address address;
    protected int customerId;
    protected double balance;
    
    public Customer(String first, String last,
            Address a) {
        super(first, last);
        address = a;
        customerId = idGenerator++;
    }
    
    public Customer(String first, String last,
            String street, String city, String state,
            String zipcode) {
        this(first, last, new Address(street, city,
                state, zipcode));
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double updateBalance(double amount){
        return balance += amount;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer(128);
        sb.append("Customer ID:");
        sb.append(customerId).append('\n');
        sb.append(super.toString()).append('\n');
        sb.append(address.toString());
        return sb.toString();
    }
}