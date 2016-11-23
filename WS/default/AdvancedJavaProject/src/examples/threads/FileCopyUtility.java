package examples.threads;
import java.io.*;
public class FileCopyUtility{
    public static void copy(File src, File dest){
        if (!src.isDirectory()){
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try{
                fis = new FileInputStream(src);
                fos = new FileOutputStream(dest);
                int theByte;
                while( (theByte = fis.read()) != -1){
                    fos.write(theByte);
                    // Simulate large file being read
                    try{Thread.sleep(10);}
                    catch(InterruptedException ie){}
                }
                fis.close();
                fos.close();
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}