package examples.logging;
import java.util.logging.*;

public class LogTest5 {

    private static Logger log =
       Logger.getLogger("examples.logging.LogTest5");	
        
    public static void main(String args[]){
        int loopCount = 40;
        if(args.length == 1)
            loopCount = Integer.parseInt(args[0]);
        for(int i = 0; i < loopCount; i++){
            log.info("Msg #" + i + " logged");
            log.finest("Msg #" + i + " logged");
        }
        System.out.println("Log File Updated with " +
            loopCount + " new records");
    }
}