package solutions.generics.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class TestProductDBFromFile {
    public static void main (String args[]) throws IOException {

        ProductDBFromFile pf = new ProductDBFromFile();
        if (! pf.open()) {
            System.err.println ("Error reading products file!");
            System.exit (-2);
        }
        
        Product aProduct;
        
        //  Display all the products
        ArrayList<Product> list = new ArrayList<Product>(pf.values());
        Collections.sort(list);
        for(Product obj: list){
            System.out.println(obj);
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
            aProduct = pf.get (productId);
            if (aProduct == null) {
                System.out.println (productId + " not found");
            } else {
                System.out.println (aProduct);
            }
        }
    }
}
