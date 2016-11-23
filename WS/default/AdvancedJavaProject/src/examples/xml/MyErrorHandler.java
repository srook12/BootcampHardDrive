package examples.xml;
import org.xml.sax.*;

public class MyErrorHandler implements ErrorHandler {

	public void error(SAXParseException e)
	 throws SAXException {
		showException("Error: ", e);
	}
	public void warning(SAXParseException e)
	 throws SAXException {
		showException("Warning: ", e);
	}
	public void fatalError(SAXParseException e)
	 throws SAXException {
		showException("Fatal Error: ", e);
		System.exit(1);
	}
	public void showException(String type,
	 SAXParseException e) {
		System.err.println(type + e.getMessage());
		String pid = e.getPublicId();
		String sid = e.getSystemId();
		int col = e.getColumnNumber();
		int line = e.getLineNumber();
		if (pid != null)
			System.err.println("    PublicId: " + pid);
		if (sid != null)
			System.err.println("    SystemId: " + sid);
		if (col != -1)
			System.err.println("    Column Number: " + col);
		if (line != -1)
			System.err.println("    Line Number: " + line);
	}
}