package examples.io;
import java.util.ArrayList;
import java.io.*;
public class ReadContacts {
    public static void main(String[] args) {
        ArrayList<Contact> contacts = readContacts();
        for(Contact contact:contacts)
            System.out.println(contact);
        System.out.println("---------------------");
        contacts = readList();
        for(Contact contact:contacts)
            System.out.println(contact);
    }
    
    public static ArrayList<Contact> readContacts(){
        ArrayList<Contact> list =
            new ArrayList<Contact>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String fileName = "contacts.ser";
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            while(true)
                list.add((Contact)ois.readObject());
        } catch (EOFException e) {
            //quietly ignore as this is expected
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            closeInput(ois);
        }
        return list;
    }
    public static ArrayList<Contact> readList(){
        ArrayList<Contact> list = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("list.ser");
            ois = new ObjectInputStream(fis);
            list =
                (ArrayList<Contact>)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            closeInput(ois);
        }
        return list;
    }
    public static void closeInput(InputStream is){
        if(is != null){
            try{
                is.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}