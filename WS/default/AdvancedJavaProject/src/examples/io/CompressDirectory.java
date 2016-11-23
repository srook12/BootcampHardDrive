package examples.io;

import java.io.*;
import java.util.zip.*;
import javax.swing.JOptionPane;

public class CompressDirectory {
    
    public static File sourceDir, sourceFile;
    public static ZipOutputStream zipOut;
    public static FileOutputStream fos;
    
    public static void main(String args[]) {
        getUserInput();
        initializeStreams();
        try {
            processDirectory(sourceDir, zipOut);
        } finally {
            closeStreams();
        }
    }
    
    public static boolean getUserInput(){
        String prompt1 = "Enter the full path of the"
            + " directory to be zipped:";
        String prompt2 = "Enter the name of the zip"
            + " file to create:";
        String d, f;
        Console c = System.console();
        if(c == null){
            d = JOptionPane.showInputDialog(prompt1);
            f = JOptionPane.showInputDialog(prompt2);
        }else{
            d = c.readLine(prompt1);
            f = c.readLine(prompt2);
        }
        if(d == null || f == null){
            System.err.print("Invalid input");
            return false;
        }
        sourceDir = new File(d);
        sourceFile = new File(f);
        if (!sourceDir.isDirectory()){
            System.err.print(d + ":not a directory");
            return false;
        }
        return true;
    }

    public static boolean initializeStreams(){
        try {
            fos = new FileOutputStream(sourceFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        zipOut = new ZipOutputStream(fos);
        return true;
    }

    public static void processDirectory(File dir,
            ZipOutputStream zipFile){
        String entries[] = dir.list();
        File file = null;
        for (String fName:entries) {
            file = new File(dir, fName);
            if (file.isDirectory())
                processDirectory(file, zipFile);
            else{
                zipTheFile(file, zipFile);
            }
        }
    }
    
    public static void zipTheFile(File file,
            ZipOutputStream zipFile){
        byte[] buffer = new byte[4096];
        int bytes;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            System.out.println("Zipping:" + file);
            ZipEntry entry =
                new ZipEntry(file.getPath());
            zipFile.putNextEntry(entry);
            while ((bytes = in.read(buffer)) != -1) {
                zipFile.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try{
                    in.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }
    
    public static void closeStreams(){
        try {
            if(zipOut != null)
                zipOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}