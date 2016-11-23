package solutions.collections.ex2;

import java.util.Iterator;
import java.io.*;

public class TestProductDBFromFile {
    public static void main (String args[]) throws IOException {

        ProductDBFromFile pf = new ProductDBFromFile();
        if (! pf.open()) {
            System.err.println ("Error reading products file!");
            System.exit (-2);
        }
        
        Product aProduct;
        
        //  Display all the products

        Iterator it = pf.values().iterator();
        while (it.hasNext()) {
            aProduct = (Product) it.next();
            System.out.println (aProduct);
        }

        //  Display selected products

        BufferedReader br = new BufferedReader 
                                (new InputStreamReader (System.in));
        String productId = "";
        while (true) {
            System.out.print ("Enter product id (or 'quit'): ");
            productId = br.readLine();
            if (productId.equalsIgnoreCase ("quit")) {
                break;
            }
            aProduct = (Product) pf.get (productId);
            if (aProduct == null) {
                System.out.println (productId + " not found");
            } else {
                System.out.println (aProduct);
            }
        }
    }
}
