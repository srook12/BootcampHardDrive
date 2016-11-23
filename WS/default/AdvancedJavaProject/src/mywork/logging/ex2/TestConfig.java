package mywork.logging.ex2;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class TestConfig {

	public static void main(String[] args) throws IOException {
		Properties p = Configuration.getConfiguration();
		
		Enumeration enumerator = p.propertyNames();

		while(enumerator.hasMoreElements()) {
			String property = (String) enumerator.nextElement();
			String value = (String) p.getProperty(property);
			System.out.println(property + "\t" + value);		
		}
		System.out.println();
		// Let's try adding another property
		p.setProperty("myfile.stuff", "dragon.dat");
		
		// Display them again
		enumerator = p.propertyNames();
		
		while(enumerator.hasMoreElements()) {
			String property = (String) enumerator.nextElement();
			String value = (String) p.getProperty(property);
			System.out.println(property + "\t" + value);		
		}
		
		// Let's persist it
		Configuration.persist();
	}

}
