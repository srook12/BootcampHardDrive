package examples.security;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.security.AccessControlException;

public class DetailedResources {

    public static void main(String[] args) throws
            Exception {
        //Read System Properties
        printSysProp("os.name");
        printSysProp("user.home");

        //Read from various files
        URI uri =
            DetailedResources.class.getResource(".").toURI();
        File path = new File(uri.getPath());
        File files [] = { new File(path, "data.txt"),
            new File(path,"../../data/products.txt"),
            new File(path,"../../../setenv.cmd"),
            new File("C:\\nosuchfile.txt")
        };
        for(File file: files){
            readFromFile(file);
        }
        
        //Write to a file
       writeToFile(files[0]);
        
        //Resolve an IP address
        resolveIP("trainingetc.com");
        
        //Read web page at that Internet Address
        readWebPage("trainingetc.com");
    }

    private static void printSysProp(String name) {
        System.out.print("Property: ");
        System.out.print(name + "=");
        try {
            System.out.println(System.getProperty(name));
        } catch (AccessControlException ace) {
            System.err.println(ace.getMessage());
        }
    }
    
    private static void readFromFile(File f){
        try {
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
        }catch (AccessControlException ace) {
            System.err.println(ace.getMessage());
        }
    }
    
    private static void writeToFile(File f){
        try {
            PrintWriter pw;
            try {
                pw = new PrintWriter(f);
                pw.println("Write this data to a file");
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (AccessControlException ace) {
            System.err.println(ace.getMessage());
        }
    }
    
    private static void resolveIP(String ip) throws
            UnknownHostException{
        try{
            InetAddress ia = 
                InetAddress.getByName(ip);
            System.out.println(ia);
        }catch (AccessControlException ace) {
               System.err.println(ace.getMessage());
        }
    }
    
    private static void readWebPage(String ip){
        try{
            String ips [] = {ip};
            examples.networking.ReadWebPage.main(ips);
        }catch (AccessControlException ace) {
            System.err.println(ace.getMessage());
        }
    }
}