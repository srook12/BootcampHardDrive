package examples.xml;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class TestBuild
{
    public static void main (String argv [])
	  throws Exception {
		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document doc;
		dbf = DocumentBuilderFactory.newInstance ();
		db = dbf.newDocumentBuilder ();
		doc = db.newDocument ();

		Element ab = doc.createElement ("addressBook");
		doc.appendChild (ab);

		Element name = doc.createElement ("name");
		Element fName = doc.createElement ("firstName");
		Element lName = doc.createElement ("lastName");

		ab.appendChild (name);
		name.appendChild (fName);

		fName.appendChild (doc.createTextNode ("Susan"));
		name.appendChild (lName);
		lName.appendChild (doc.createTextNode ("Jones"));

		traverse(ab, "");
    }

	protected static void traverse(Node n,
		String indent) {

		for (Node nod = n; nod != null;
		nod = nod.getNextSibling()) {
			short type  = nod.getNodeType();
			String name = nod.getNodeName();
			String val  = nod.getNodeValue();
			switch (type) {
				case Node.ELEMENT_NODE:
					System.out.println(indent + "<" + name + ">");
					break;
				case Node.TEXT_NODE:
					// Ignore text that is only whitespace.
					if (val.trim().equals("")) break;
					System.out.println( indent + val );
					break;
			}

			Node child = nod.getFirstChild();

			// increase the indent and process
			// the children's children
			if (child != null)
				traverse(child, indent + "     ");
			if( nod.getNodeType() == Node.ELEMENT_NODE)
				System.out.println(indent + "</" + nod.getNodeName() + ">");
		}
	}
}
