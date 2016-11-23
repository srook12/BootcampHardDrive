package examples.resources.good;
import java.io.*;
public class ReadAFile {
    public static void main(String[] args) 
      throws Exception {
        Class c = ReadAFile.class;
        InputStream fis = 
            c.getResourceAsStream("data.txt");
        int data;
        while((data = fis.read()) != -1){
            System.out.print((char) data);
        }
        fis.close();
        System.out.println();
        fis = c.getResourceAsStream("data.txt");
        InputStreamReader isr =
            new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String txt;
        while((txt = br.readLine()) != null){
            System.out.println(txt);
        }
        br.close();
    }
}