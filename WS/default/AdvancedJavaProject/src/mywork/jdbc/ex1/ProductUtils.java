package mywork.jdbc.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import mywork.collections.ex1.Product;

public class ProductUtils {
	private static BufferedReader br;
	
	private ProductUtils() { }
	
	public static Product[] createProductInventory() {
		List<Product> inventory = new ArrayList<Product>();
		Product[] dummyArray = new Product[0];
		
		String[] itemList = open();
		
		for(String item : itemList)
			inventory.add(constructProduct(item));
		
		close();
		
		return inventory.toArray(dummyArray);
	}
	
	private static Product constructProduct(String item) {
		String[] productValues = item.split(",");
    	return new Product(productValues[0], productValues[1], productValues[2],
    			Double.parseDouble(productValues[3]), 
    			Integer.parseInt(productValues[4]), 
    			Integer.parseInt(productValues[5]));
	}
	
	private static String[] open() {
		List<String> inventory = new ArrayList<String>();
		String[] dummyArray = new String[0];
		
		try {
			InputStream is = (new ProductUtils()).getClass().getResourceAsStream("products.txt");
            br = new BufferedReader (new InputStreamReader(is));
            String line;
            
            while((line = br.readLine())!= null) {
            	inventory.add(line);
            }
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return inventory.toArray(dummyArray);
	}
	
	private static void close() {
		try {
			if(br != null)
				br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
