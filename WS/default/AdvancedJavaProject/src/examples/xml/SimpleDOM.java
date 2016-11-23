package examples.xml;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

public class SimpleDOM {
    public static void main (String args [])
		throws Exception {

		FileInputStream in;
		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document doc;

		in = new FileInputStream(args[0]);
		dbf = DocumentBuilderFactory.newInstance ();
		db = dbf.newDocumentBuilder ();
		doc = db.parse(in);
	}
}