package examples.threads;
import java.io.*;
public class FileDisplay extends Thread {
    public static void main(String args[]){
        for(int i = 0; i < args.length; i++){
            File source = new File(args[i]);
            File dest =
                new File ("copiedfiles/" + args[i]);
            System.out.println();
            System.out.println("Copying " + args[i]);
            FileCopyUtility.copy(source, dest);
        }
    }
}