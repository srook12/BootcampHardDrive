package examples.io;
import java.io.*;

public class CustomReaderTest {
    public static void main(String args[])
            throws IOException {
        CustomReader cr = new CustomReader(args[0]);
        BufferedReader br = new BufferedReader(cr);
        String theLine;
        while ((theLine = br.readLine()) != null) {
            System.out.println(theLine);
        }
        br.close();
    }
}