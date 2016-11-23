package examples.io;
import java.io.*;
public class BufferedFileCopy {
    public static void main(String args[]){
        BufferedReader br = null;
        PrintWriter pw = null;
        BufferedReader kb = new BufferedReader(
                new InputStreamReader(System.in));
        String prompt = "Name of the file to ";
        System.out.println(prompt + "read from:");
        String fromFile, toFile;
        try {
            fromFile = kb.readLine();
            System.out.println(prompt + "write to:");
            toFile = kb.readLine();
        } catch (IOException e) {
            System.err.println("Can't read from kb");
            return;
        }
        
        try {
            br = new BufferedReader(
                    new FileReader(fromFile));
            pw = new PrintWriter(toFile);
            String theLine;
            while((theLine = br.readLine())!= null){
                System.out.println(theLine);
                pw.println(theLine);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}