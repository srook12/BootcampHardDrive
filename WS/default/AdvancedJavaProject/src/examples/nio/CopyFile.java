package examples.nio;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
public class CopyFile {
    public static void main (String args[]){
        FileChannel in = null;;
        FileChannel out = null;
        try {
            FileInputStream fis =
                new FileInputStream(args[0]);
            FileOutputStream fos =
                new FileOutputStream(args[1]);
            in = fis.getChannel();
            out = fos.getChannel();
            ByteBuffer buffer =
                ByteBuffer.allocate(1024);
            while((in.read(buffer)) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}