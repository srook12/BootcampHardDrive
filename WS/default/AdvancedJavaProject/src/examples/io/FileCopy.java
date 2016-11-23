package examples.io;
import java.io.*;
public class FileCopy {
    public static void main(String args[])
            throws IOException {
        String prompt = "Indicate the type of file"
                + "\n(1) Binary File\n(2)Text File";
        System.out.println(prompt);
        char choice = (char) System.in.read();
        if (choice == '1') {
            FileInputStream input =
                new FileInputStream(args[0]);
            FileOutputStream output =
                new FileOutputStream(args[1]);
            copy(input, output);
            input.close();
            output.close();
        } else if (choice == '2') {
            FileReader input =
                new FileReader(args[0]);
            FileWriter output =
                new FileWriter(args[1]);
            copy(input, output);
            input.close();
            output.close();
        }
    }

    private static void copy(InputStream input,
            OutputStream output) throws IOException {
        int data;
        while ((data = input.read()) != -1)
            output.write(data);
    }

    private static void copy(Reader input,
            Writer output) throws IOException {
        int data;
        while ((data = input.read()) != -1)
            output.write(data);
    }
}