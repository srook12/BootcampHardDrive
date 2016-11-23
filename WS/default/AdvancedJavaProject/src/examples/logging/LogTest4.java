package examples.logging;
import java.util.logging.*;

public class LogTest4 {

    private static Logger log =
       Logger.getLogger("examples.logging.LogTest4");	
        
    public static void main(String args[]){
        String p = "%tsampleLog%g.log";
        try {
            Handler h =
                new FileHandler(p, 2000, 4, true);
            h.setFormatter(new SimpleFormatter());
            log.addHandler(h);
        }catch (java.io.IOException e) {
            String msg = "Unable to create log file"
                + ":Using System defaults instead";
            log.warning(msg);
        }

        // turn off root loggers handlers
        Handler [] handlers =
            Logger.getLogger("").getHandlers();
        for(int i = 0; i < handlers.length; i++){
            handlers[i].setLevel(Level.OFF);
        }

        // set class logger to FINE
        log.setLevel(Level.FINE);
        int loopCount = 40;
        if(args.length == 1)
            loopCount = Integer.parseInt(args[0]);
        for(int i = 0; i < loopCount; i++){
                log.info("Msg #" + i + " logged");
        }
        System.out.println("Log File Updated with " +
            loopCount + " new records");
    }
}