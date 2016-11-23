package examples.io;

import java.io.*;
import java.util.Properties;

public class ConfigUtil {
    static Properties p;
    static String cnfgFile = "config.properties";
    static {
        p = new Properties();
        p.put("time.format", "%tr");
        p.put("date.format", "%tD");
        p.put("user", "New User");
        File f = new File(cnfgFile);
        if(f.exists()){
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(cnfgFile);
                p.load(fis);
                fis.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    public static void persist() throws IOException{
        FileOutputStream fos =
            new FileOutputStream(cnfgFile);
        p.store(fos, "Sample Config File");
        fos.close();
    }
    public static Properties getConfiguration(){
        return p;
    }
}