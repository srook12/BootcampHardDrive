package examples.xml;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMEcho {
    public static void main (String args [])
		throws Exception {

		if (args.length != 1) {
			System.out.println("usage: " +
				"java DOMEcho xmlFileName");
			System.exit(1);
		}
		File in = new File(args[0]);
		if (in.exists() == false) {
			System.err.println("The file " +
				args[0] + " does not exist!");
			System.exit(2);
		}
		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document doc;
		dbf = DocumentBuilderFactory.newInstance ();
		db = dbf.newDocumentBuilder ();
		doc = db.parse(new FileInputStream(args[0]));

		// process ALL child nodes passing the Document
		// Node and an initial indent of an empty string
		// as parameters		
		processChildNodes(doc, "");
	}
	protected static void
		processChildNodes(Node n, String indent) {
		
		for (Node nod = n; nod != null;
			nod = nod.getNextSibling())
		{
			short type  = nod.getNodeType();
			String name = nod.getNodeName();
			String val  = nod.getNodeValue();
			switch (type) {
				case Node.CDATA_SECTION_NODE:
					System.out.println(indent +
						"CDATA_SECTION NODE: " + name);
					break;
				case Node.COMMENT_NODE:
					System.out.println(indent +
						"COMMENT NODE: " + name);
					break;
				case Node.DOCUMENT_FRAGMENT_NODE:
					System.out.println(indent +
						"DOCUMENT_FRAGMENT NODE: " + name);
					break;
				case Node.DOCUMENT_NODE:
					System.out.println(indent +
						"DOCUMENT NODE: " + name);
					break;
				case Node.DOCUMENT_TYPE_NODE:
					System.out.println(indent +
						"DOCUMENT_TYPE NODE: " + name);
					break;
				case Node.ENTITY_NODE:
					System.out.println(indent +
						"ENTITY NODE: " + name);
					break;
				case Node.ENTITY_REFERENCE_NODE:
					System.out.println(indent +
						"ENTITY_REFERENCE NODE: " + name);
					break;
				case Node.NOTATION_NODE:
					System.out.println(indent +
						"NOTATION NODE: " + name);
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					System.out.println(indent +
						"PROCESSING_INSTRUCTION NODE: " + name);
					break;
				case Node.ELEMENT_NODE:
					System.out.println(indent +
						"ELEMENT NODE: " + name);
					Element e = (Element) nod;

					// See if this element has any attributes.
					NamedNodeMap nnm = e.getAttributes();
					for (int i = 0; i < nnm.getLength(); i++) {
						Attr a = (Attr)(nnm.item(i));
						System.out.println(indent +
							"  ATTRIBUTE NODE: " + a.getName() +
							" = [" + a.getValue() + "]");
					}
					break;
				case Node.TEXT_NODE:
					// Ignore text that is only whitespace.
					if (val.trim().equals("")) break;
					System.out.println(indent + "TEXT NODE: " +
						"[" + val + "]");
					break;
			}

			Node child = nod.getFirstChild();

			// increase the indent and process
			// the children's children
			if (child != null)
				processChildNodes(child, indent + "    ");
		}
	}
}