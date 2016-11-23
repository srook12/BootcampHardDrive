package mywork.io.ex3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    static Properties p;
    static String configFile = "src/data/configuration.cfg";
    
    static {
        p = new Properties();
        InputStream is = null;
        // Create InputStream from "configuration.cfg"
        // and load its properties into 'p'.
        
        // Defaults
        p.put("textfile.name", "default.txt");
        p.put("serfile.name", "default.ser");
        
        if(new File(configFile).exists()) {
        	try {
        		is = new FileInputStream(configFile);
        		p.load(is);
        		is.close();
        	}
        	catch (IOException e) {
        		e.printStackTrace();
        	}
        }
    }
    
    public static void persist() throws IOException {
    	FileOutputStream fos = new FileOutputStream(configFile);
    	p.store(fos, "");
    	fos.close();
    }
    
    public static Properties getConfiguration(){
        return p;
    }
}