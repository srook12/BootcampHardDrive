package mywork.io.ex4;

import java.util.*;
import java.io.*;

import mywork.collections.ex1.Product;
import mywork.io.ex3.Configuration;

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

public class ProductDBFromSerFile extends HashMap implements Database {
    
	private final static String FILE_NAME = "src/data/products.txt";	
	ObjectInputStream ois = null;
 
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
    	System.out.println("Reading from serialized file!");
        boolean successFlag = true; //assume success
                            
        try{
        	Properties p = Configuration.getConfiguration();
        	
        	try {
        		ois = new ObjectInputStream(new FileInputStream(p.getProperty("serfile.name")));
        		while(true) {            	
        			Product product = (Product) ois.readObject();
        			put(product.getId(), product);
        		}
        	}
        	catch (EOFException e) {
        		// ignore
        	}
            
        }catch(Exception e){
            successFlag = false;
            e.printStackTrace();
        }finally{
            // close any i/o classes used
        }
        return successFlag;
    }
    
    /**, 
    *   Saves the data in the HashMap back into the data file.
    *   For now, this method can simply return true as we won't
    *   be updating the product database in this project.
    */
    
    public boolean close() {
    	try {
			if(ois != null)
				ois.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
        return true;
    }
    
}
