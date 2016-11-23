package starters.io.ex3;

import java.io.*;
import java.util.Properties;

import data.ResourceLocator;

public class Configuration {
    static Properties p;
    static {
        p = new Properties();
        InputStream is = null;
        // Create InputStream from "configuration.cfg"
        // and load its properties into 'p'.
    }
    public static Properties getConfiguration(){
        return p;
    }
}