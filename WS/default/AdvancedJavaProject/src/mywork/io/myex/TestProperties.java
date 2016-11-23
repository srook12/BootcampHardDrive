package mywork.io.myex;

import java.util.Enumeration;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) {
		Properties p = ConfigInitializer.loadProperties();

		// Write out my properties
		Enumeration<?> e = p.propertyNames();
		while(e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = p.getProperty(key);
			System.out.println(key + "\t" + value);
		}
	}

}
