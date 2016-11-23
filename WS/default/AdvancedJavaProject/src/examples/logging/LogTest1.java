package examples.logging;

import java.util.logging.Logger;

public class LogTest1 {

    private static Logger log =
       Logger.getLogger("examples.logging.LogTest1");	
        
    public static void main(String args[]){
        log.finest("Logged at Finest level");
        log.finer("Logged at Finer level");
        log.fine("Logged at Fine level");
        log.config("Logged at Config level");
        log.info("Logged at Info level");
        log.warning("Logged at Warning level");
        log.severe("Logged at Severe level");
    }
}