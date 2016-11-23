package examples.xml;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

public class SimpleReader extends DefaultHandler {
    public static void main (String args[])
	  throws Exception{
		if (args.length != 1) {
			System.err.println("usage: " +
				"java SimpleReader xmlFileName");
			System.exit(1);
		}

		File in = new File(args[0]);
		if (in.exists() == false) {
			System.err.println("The file " +
				args[0] + " does not exist!");
			System.exit(2);
		}
		String uri = "file:" + in.getAbsolutePath();

		SAXParserFactory spf;
		SAXParser sp;
		XMLReader reader;
		spf = SAXParserFactory.newInstance();
		sp = spf.newSAXParser();
		reader = sp.getXMLReader();
		reader.setContentHandler(new SimpleReader());
		reader.parse(uri);
	}
}