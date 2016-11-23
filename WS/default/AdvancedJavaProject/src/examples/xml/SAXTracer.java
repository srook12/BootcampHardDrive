package examples.xml;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

public class SAXTracer implements ContentHandler {
	public static void main (String args[])
	 throws Exception {
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
		reader.setContentHandler(new SAXTracer());
		reader.setErrorHandler(new MyErrorHandler());
		reader.parse(uri);
	}

	// Supply Concrete SAX DocumentHandler methods
	public void startDocument() 
	 throws SAXException {
		System.out.println("Starting to Parse document");
	}

	public void endDocument()
	 throws SAXException {
		System.out.println("Done parsing document");
	}

	public void startElement(String namespaceURI,
	  String localName, String qName, Attributes attrs)
	  throws SAXException {
		System.out.println("start element: " + qName);
		if (attrs != null) {
			for (int i = 0; i < attrs.getLength(); i++) {
				System.out.println("attribute:" + 
					attrs.getQName(i) + " with value " +
					attrs.getValue(i));
			}
		}
	}

	public void endElement(	String namespaceURI,
	 String localName, String qName)
	 throws SAXException {
		System.out.println("End element " + qName);
	}

	public void characters (char buf [], int offset,
	 int len) throws SAXException {
		if (len > 1) {
			System.out.print("chars: ");
         	for (int i = offset; i < (offset + len); i++)
				System.out.print(buf[i]);
			System.out.println();
		}
	}

	public void ignorableWhitespace(char buf[],
	 int offset, int len) throws SAXException {
	}

	public void processingInstruction (String target,
	 String data) throws SAXException {
	}

	public void startPrefixMapping(String prefix,
	 String uri) throws SAXException {
	}

	public void endPrefixMapping(String prefix)
	 throws SAXException {
	}

	public void skippedEntity(String name)
	 throws SAXException {
	}

	public void setDocumentLocator (Locator loc) {
	}
}