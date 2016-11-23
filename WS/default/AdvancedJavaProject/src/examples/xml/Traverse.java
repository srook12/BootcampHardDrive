package examples.xml;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Traverse {
    public static void main (String args [])
		throws Exception {

		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document doc;
		dbf = DocumentBuilderFactory.newInstance ();
		db = dbf.newDocumentBuilder ();
		doc = db.parse(new FileInputStream(args[0]));

		NodeList books =
			doc.getElementsByTagName("book");
		int numBooks = books.getLength();

		for (int i = 0; i < numBooks; i++) {
			Element book = (Element) books.item(i);
			System.out.println("\nbook: ISBN = "
				+ book.getAttribute("ISBN"));

			NodeList children = book.getChildNodes();
			for(int j = 0; j < children.getLength(); j++) {
				Node child = children.item(j);

				// Ignore nodes that are not Elements
				if (! (child instanceof Element)) continue;
				System.out.print(child.getNodeName() + ": ");
				Node textNode = child.getFirstChild();
				if ((textNode != null) &&
					(textNode.getNodeType() == Node.TEXT_NODE)) {
					Text t = (Text) textNode;
					System.out.println(t.getData());
				}
			}
		}
	}
}