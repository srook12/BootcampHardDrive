package solutions.io.ex4;

import java.util.*;
import java.io.*;

import solutions.io.ex2.Product;
import solutions.io.ex3.Configuration;

import data.ResourceLocator;

/**
*   Product data is read from a file and stored as a HashMap.  The
*   entire file is read into the HashMap, and all requests for data
*   will come directly from the HashMap in memory, using the methods
*   inherited from the HashMap class (primarily the get() method).
*
*   The file is a "flat" file containing ASCII text.  The data file
*   provided for the project is called "products.txt".  Each record
*   corresponds to one product, and the fields are comma-separated.
*/

public class ProductDBFromSer extends HashMap<String, Product> implements Database {
    
 
    /* 
    *   Reads from the products.txt file supplied in the data directory     
    *   Opens the data file.  Reads each record and creates a Product
    *   object, then stores it in the hash map using the product id as
    *   the key and the Product object as the value.
    *
    *   (Hints:  Use String.split(",") to parse the records.  Use the put() 
    *            method of HashMap to store key/value pairs in the map.)
    *
    *   Returns false if any exceptions occur, otherwise true.
    */
    
    public boolean open () {
        boolean successFlag = true; //assume success
        ObjectInputStream ois = null;
        try{
            Properties p = Configuration.getConfiguration();
            String s = p.getProperty("serfile.name");
            InputStream is = ResourceLocator.class.getResourceAsStream(s);
            ois = new ObjectInputStream(is);
            Product aProduct;
            while (true) {
                aProduct = (Product)ois.readObject();
                put (aProduct.getId(), aProduct);
            }
        }catch(EOFException e){
            // Quietly Ignore
        }catch(Exception e){
            successFlag = false;
            e.printStackTrace();
        }finally{
            // close any i/o classes used
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return successFlag;
    }

    /**
    *   Saves the data in the HashMap back into the data file.
    *   For now, this method can simply return true as we won't
    *   be updating the product database in this project.
    */
    
    public boolean close() {
        return true;
    }
}
