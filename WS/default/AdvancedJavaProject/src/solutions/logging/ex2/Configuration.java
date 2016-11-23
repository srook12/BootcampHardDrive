package solutions.logging.ex2;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import data.ResourceLocator;

public class Configuration {
    static Properties p;
    private static Logger log = Logger.getLogger("solutions.logging");
    static {
        p = new Properties();
        InputStream is =
            ResourceLocator.class.getResourceAsStream("configuration.cfg");
        try {
            p.load(is);
            is.close();
            for(Object key: p.keySet()){
                log.config(key + "=" + p.get(key));
            }
        } catch (IOException ioe) {
            log.log(Level.WARNING, "Unable to load config\n", ioe);
            ioe.printStackTrace();
        }
    }
    public static Properties getConfiguration(){
        return p;
    }
}