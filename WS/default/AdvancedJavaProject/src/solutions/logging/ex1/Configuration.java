package solutions.logging.ex1;

import java.io.*;
import java.util.Properties;

import data.ResourceLocator;

public class Configuration {
    static Properties p;
    static {
        p = new Properties();
        InputStream is =
            ResourceLocator.class.getResourceAsStream("configuration.cfg");
        try {
            p.load(is);
            is.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public static Properties getConfiguration(){
        return p;
    }
}