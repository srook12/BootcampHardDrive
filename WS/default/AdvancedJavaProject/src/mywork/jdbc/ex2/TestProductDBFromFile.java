package mywork.jdbc.ex2;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import mywork.collections.ex1.Product;

public class TestProductDBFromFile {
    public static void main (String args[]) throws IOException {

        ProductDBFromFile pf = new ProductDBFromFile();
        if (! pf.open()) {
            System.err.println ("Error reading products file!");
            System.exit (-2);
        }
        
        Product aProduct;
        
        //  Display all the products
        TreeMap orderedProducts = new TreeMap(pf);

        Iterator it = orderedProducts.values().iterator();
        System.out.println(Product.tableLabels());
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
            	System.out.println(Product.tableLabels());
                System.out.println (aProduct);
            }
        }
    }
}
