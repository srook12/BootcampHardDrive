package examples.security;

import java.io.*;
import java.net.*;

public class Resources {

    public static void main(String[] args) throws
            Exception {
        //Read System Properties
        printSysProp("os.name");
        printSysProp("user.home");
        
        //Read from various files
        URI uri =
            Resources.class.getResource(".").toURI();
        File path = new File(uri.getPath());
        String fileNames [] = { "data.txt",
            "../../data/products.txt",
            "../../data/nosuchfile.txt"
        };
        for(String fileName: fileNames){
            readFromFile(new File(path, fileName));
        }
        
        //Write to a file
        writeToFile(new File(path, fileNames[0]));
        
        //Resolve an IP address
        resolveIP("trainingetc.com");
        
        //Read web page at that Internet Address
        readWebPage("trainingetc.com");
    }

    private static void printSysProp(String name) {
        System.out.print("Property: ");
        System.out.print(name + "=");
        System.out.println(System.getProperty(name));
    }
    
    private static void readFromFile(File f){
        if(!f.exists()){
            return;
        }
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            System.out.println(br.readLine());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void writeToFile(File f){
        PrintWriter pw;
        try {
            pw = new PrintWriter(f);
            pw.println("Write this data to a file");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void resolveIP(String ip) throws
            UnknownHostException{
        InetAddress ia = 
            InetAddress.getByName(ip);
        System.out.println(ia);
    }
    
    private static void readWebPage(String ip){
        String ips [] = {ip};
        examples.networking.ReadWebPage.main(ips);
    }
}