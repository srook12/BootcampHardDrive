package examples.xml;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

public class SimpleSAX extends DefaultHandler {
    public static void main (String args[])
	  throws Exception{
		if (args.length != 1) {
			System.err.println("usage: " +
				"java SimpleSAX xmlFileName");
			System.exit(1);
		}

		File in = new File(args[0]);
		if (in.exists() == false) {
			System.err.println("The file " +
				args[0] + " does not exist!");
			System.exit(2);
		}

		SAXParserFactory spf;
		SAXParser sp;
		spf = SAXParserFactory.newInstance();
		sp = spf.newSAXParser();
		sp.parse(in, new SimpleSAX());
	}
}