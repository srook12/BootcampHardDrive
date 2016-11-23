package examples.resources.bad;
import java.io.*;
public class ReadAFile {
    public static void main(String[] args) 
      throws IOException {
        String fileName =
            "bin/examples/resources/bad/data.txt";
        FileInputStream fis =
            new FileInputStream(fileName);
        int data;
        while((data = fis.read()) != -1)
            System.out.print((char) data);
        fis.close();
        System.out.println();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String txt;
        while((txt = br.readLine()) != null)
            System.out.println(txt);
        br.close();
    }
}