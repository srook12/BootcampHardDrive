package mywork.io.ex2;

import java.util.Iterator;
import java.io.*;
import mywork.collections.ex1.Product;

public class SerializeProductDB {
    public static void main (String args[]) throws IOException {

    	if(args.length != 1) {
    		System.err.println("Required: SerializeProductDB <Object output file>");
    		System.exit(2);
    	}
    	
        ProductDBFromFile pf = new ProductDBFromFile();
        if (! pf.open()) {
            System.err.println ("Error reading products file!");
            System.exit (-2);
        }
        
        Product aProduct;
        
        //  Serialize all the products
        ObjectOutputStream oos = null;
               
        try {
        	oos = new ObjectOutputStream(new FileOutputStream(args[0]));
        
        	for(Object o : pf.values()) {
        		oos.writeObject(o);
        	}
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        finally {
        	if (oos!=null)
        		oos.close();
        }
        
        /*
        Iterator it = pf.values().iterator();
        System.out.println(Product.tableLabels());
        while (it.hasNext()) {
            aProduct = (Product) it.next();
            System.out.println (aProduct);
        }
        */
    }
}
