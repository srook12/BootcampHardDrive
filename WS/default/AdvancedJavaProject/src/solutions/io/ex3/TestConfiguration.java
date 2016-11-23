package solutions.io.ex3;

import java.util.Properties;

public class TestConfiguration {

    public static void main(String[] args) {
       Properties p = Configuration.getConfiguration();
       String s1 = p.getProperty("textfile.name");
       String s2 = p.getProperty("serfile.name");
       System.out.println("Text File is:" + s1);
       System.out.println("Serialized File is:" + s2);
    }
}