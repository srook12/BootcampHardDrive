package examples.io;

import java.util.ArrayList;
import java.io.*;

public class WriteContacts {
    static ArrayList<Contact> list;
    public static void main(String[] args) {
        getContacts();
        persistContacts();
        persistList();
    }
    
    public static void getContacts(){
        list = new ArrayList<Contact>();
        list.add(new Contact("Joe", "Columbia", "MD",
                21046));
        list.add(new Contact("Ann", "Bowie", "MD",
                20715));
        list.add(new Contact("Bob", "Fairfax", "VA",
                20151));
    }
    
    public static void persistContacts(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        String fileName = "contacts.ser";
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            for(Contact contact:list)
                oos.writeObject(contact);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            closeOutput(oos);
        }
    }
    
    public static void persistList(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        String fileName = "list.ser";
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            closeOutput(oos);
        }
    }
    
    public static void closeOutput(OutputStream os){
        if(os != null){
            try{
                os.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}