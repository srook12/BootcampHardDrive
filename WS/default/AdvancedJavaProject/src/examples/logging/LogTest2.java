package examples.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTest2 {

    private static Logger log =
       Logger.getLogger("examples.logging.LogTest2");	
        
    public static void main(String args[]){

        Handler [] handlers =
            Logger.getLogger("").getHandlers();

        for(int i = 0; i < handlers.length; i++){
            handlers[i].setLevel(Level.FINE);
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