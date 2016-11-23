package examples.threads;
import java.io.*;
public class FileCopier1 {
    public static void main(String args[]){
        File temp = new File("C:/output");
        temp.mkdir();
        for(int i = 0; i < args.length; i++){
            File source = new File(args[i]);
            File dest =
                new File (temp, args[i]);
            System.out.println();
            System.out.println("Copying " + args[i]);
            FileCopyUtility.copy(source, dest);
        }
    }
}