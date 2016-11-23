package examples.logging;

import java.io.IOException;
import java.util.logging.*;

public class LogTest3 {

    private static Logger log =
       Logger.getLogger("examples.logging.LogTest3");	
        
    public static void main(String args[]){
        try {
            Handler h1 = new FileHandler("log.txt");
            Handler h2 = new FileHandler("log.xml");
            h1.setFormatter(new SimpleFormatter());
            log.addHandler(h1);
            h2.setFormatter(new XMLFormatter());
            log.addHandler(h2);
        }catch (IOException e) {
            String msg = "Unable to create log file"
                + ":Using System defaults instead";
            log.warning(msg);
        }
    
        log.setLevel(Level.FINE);
            
        log.finest("Logged at Finest level");
        log.finer("Logged at Finer level");
        log.fine("Logged at Fine level");
        log.config("Logged at Config level");
        log.info("Logged at Info level");
        log.warning("Logged at Warning level");
        log.severe("Logged at Severe level");
    }
}