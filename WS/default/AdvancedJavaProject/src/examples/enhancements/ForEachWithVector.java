package examples.enhancements;

import java.util.Enumeration;
import java.util.Properties;

public class ForEachWithVector {
    public static void main(String args[]){
        Properties sysProps = System.getProperties();
        oldForLoop(sysProps);
        System.out.println("\n\n--------------\n\n");
        newForLoop(sysProps);
    }
    
    private static void oldForLoop(Properties p){
        Enumeration e;
        for(e= p.elements(); e.hasMoreElements();)
            System.out.println(e.nextElement());
    }
    
    private static void newForLoop(Properties p){
        for(Object value : p.values())
            System.out.println(value);
    }
}