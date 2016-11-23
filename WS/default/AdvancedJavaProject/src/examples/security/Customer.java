package examples.security;

import java.io.*;

public class Customer implements Serializable{
    private String ccNumber;
    private String name;

    public Customer(String ccNumber, String name) {
        this.ccNumber = ccNumber;
        this.name = name;
    }
    public String getCcNumber() {
        return "****-****-****-" +
            ccNumber.substring(15);
    }
    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }
    public String toString(){
        return name + ", " + getCcNumber();
    }
    public static void main(String[] args)
            throws Exception {
        String number = "0000-1111-2222-3333";
        Customer customer =
            new Customer(number, "Joe Smith");
        Class c = Customer.class;
        File path =
            new File(c.getResource(".").toURI());
        File f = new File(path, "customers.ser");
        FileOutputStream fos =
            new FileOutputStream(f);
        ObjectOutputStream oos =
            new ObjectOutputStream(fos);
        oos.writeObject(customer);
        oos.close();
    }
}