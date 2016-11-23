package examples.io;

import java.io.IOException;
import java.util.*;

public class ConfigTester {
    public static void main(String args[])
            throws IOException {
        Properties p = ConfigUtil.getConfiguration();
        outputData(p);
        p.put("user", "Joe Smith");
        p.put("time.format", "%tT");
        p.put("date.format", "%tc");
        System.out.println("---------------");
        outputData(p);
        ConfigUtil.persist();
    }
    public static void outputData(Properties p){
        System.out.println(p.getProperty("user"));
        String tFrmt = p.getProperty("time.format");
        String dFrmt = p.getProperty("date.format");
        Calendar c = Calendar.getInstance();
        System.out.printf(tFrmt + "%n", c);
        System.out.printf(dFrmt + "%n", c);
    }
}