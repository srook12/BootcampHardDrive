package examples.io;
import java.io.*;
public class CustomReader extends FilterReader {

    public CustomReader(File f) 
            throws FileNotFoundException {
        this(new FileReader(f));
    }
    
    public CustomReader(String s)
            throws FileNotFoundException {
        this(new File(s));
    }
    
    public CustomReader(Reader in) {
        super(in);
    }
    
    public int read(char[] ary, int offset, int len)
            throws IOException {
        int cnt = super.read(ary, offset, len);
        if (cnt == -1)
            return -1;
        for (int i = offset; i < offset + cnt; i++) {
            ary[i] = Character.toUpperCase(ary[i]);
        }
        return cnt;
    }
    
    public int read() throws IOException {
        char[] buf = new char[1];
        int result = read(buf, 0, 1);
        return result == -1 ? -1 : buf[0];
    }
}