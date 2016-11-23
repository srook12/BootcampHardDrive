package solutions.io.ex2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import data.ResourceLocator;

public class SerializeProductDB {
    public static void main (String args[]) throws IOException {

        ProductDBFromFile pf = new ProductDBFromFile();
        if (! pf.open()) {
            System.err.println ("Error reading products file!");
            System.exit (-2);
        }
        ObjectOutputStream oos = null;
        try{
            File path = new File(ResourceLocator.class.getResource(".").toURI());
            System.out.println("Writing to the following file:");
            System.out.println(path.getPath() + "\\products.ser");
            FileOutputStream fos = new FileOutputStream(path.getPath() + "\\products.ser");
            oos = new ObjectOutputStream(fos);
            //Persist the product objects
            for(Product p:pf.values()){
                oos.writeObject(p);
            }
        }catch(Exception ioe){
            ioe.printStackTrace();
        }finally{
            try{
                oos.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
