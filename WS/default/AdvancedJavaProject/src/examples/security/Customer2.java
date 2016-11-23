package examples.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Customer2 implements Serializable{
    private transient String ccNumber;
    private String name;

    public Customer2(String ccNumber, String name) {
        this.ccNumber = ccNumber;
        this.name = name;
    }
    public String getCcNumber() {
        return "****-****-****-" +
            ccNumber.substring(15);
    }
    public String toString(){
        return name + ", " + getCcNumber();
    }
    
    private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException {
        // Read all fields that are not transient or
        //   static
        in.defaultReadObject();
        //Read transient data and Decrypt
        byte data [] = new byte[24];
        in.read(data, 0, data.length);
        try {
            ccNumber = CCEncrypter.decrypt(data);
        } catch (Exception exception) {
            throw new IOException("Cannot decrypt",
                    exception);
        } 
    }
    private void writeObject(ObjectOutputStream out)
        throws IOException{
        // Write all fields that are not transient or
        //   static
        out.defaultWriteObject();
        //Encrypt and Write transient data
        byte [] data;
        try {
            data = CCEncrypter.encrypt(ccNumber);
            out.write(data, 0, data.length);
        } catch (Exception exception) {
            throw new IOException("Cannot encrypt",
                    exception);
        } 
    }
    
    public static void main(String[] args)
            throws Exception {
        String number = "0000-1111-2222-3333";
        Customer2 customer =
            new Customer2(number, "Joe Smith");
        Class c = Customer2.class;
        File path =
            new File(c.getResource(".").toURI());
        File f = new File(path, "customers2.ser");
        FileOutputStream fos =
            new FileOutputStream(f);
        ObjectOutputStream oos =
            new ObjectOutputStream(fos);
        oos.writeObject(customer);
        oos.close();
        
        
        FileInputStream fis =
            new FileInputStream(f);
        ObjectInputStream ois =
            new ObjectInputStream(fis);
        Customer2 cust = (Customer2)ois.readObject();
        oos.close();
        System.out.println(cust.ccNumber);
        
    }
}