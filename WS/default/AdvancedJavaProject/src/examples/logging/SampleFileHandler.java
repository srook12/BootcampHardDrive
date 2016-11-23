package examples.logging;

import java.io.IOException;
import java.util.logging.FileHandler;

public class SampleFileHandler extends FileHandler {

    public SampleFileHandler() throws IOException, SecurityException {
	super();
    }

    public SampleFileHandler(String pattern, boolean append) throws IOException, SecurityException {
	super(pattern, append);
    }

    public SampleFileHandler(String pattern, int limit, int count, boolean append) throws IOException, SecurityException {
	super(pattern, limit, count, append);
    }

    public SampleFileHandler(String pattern, int limit, int count) throws IOException, SecurityException {
	super(pattern, limit, count);
    }

    public SampleFileHandler(String pattern) throws IOException, SecurityException {
	super(pattern);
    }
}
