package examples.review;

import java.io.*;

public class IOCleanupUtils {
    private static final String MSG =
        "Unable to close";
    
    private IOCleanupUtils(){}
    
    public static void cleanup(Reader reader){
        if(reader != null)
            try{
                reader.close();
            }catch(IOException ioe){
                System.err.println(MSG);
            }
    }
    public static void cleanup(Writer writer){
        if(writer != null)
            try{
                writer.close();
            }catch(IOException ioe){
                System.err.println(MSG);
            }
    }
    public static void cleanup(InputStream is){
        if(is != null)
            try{
                is.close();
            }catch(IOException ioe){
                System.err.println(MSG);
            }
    }
    public static void cleanup(OutputStream os){
        if(os != null)
            try{
                os.close();
            }catch(IOException ioe){
                System.err.println(MSG);
            }
    }
}