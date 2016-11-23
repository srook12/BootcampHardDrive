package mywork.io.myex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigInitializer {
	private static Properties p;
	
	// So we load the properties file only once
	static {
		FileInputStream fis = null;
		p = new Properties();
		p.setProperty("letter.a", "0");
		p.setProperty("letter.b", "0");
		p.setProperty("letter.c", "0");
		p.setProperty("letter.d", "0");
		p.setProperty("letter.e", "0");
		p.setProperty("letter.f", "0");
		p.setProperty("letter.g", "0");
		p.setProperty("letter.h", "0");
		p.setProperty("letter.i", "0");
		p.setProperty("letter.j", "0");
		p.setProperty("letter.w", "0");
		p.setProperty("letter.x", "0");
		
		try {
			fis = new FileInputStream(System.getProperty("config.file.location"));
			
			
			p.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void persist() throws IOException {
		FileOutputStream fos = new FileOutputStream(System.getProperty("config.file.location"));
		p.store(fos, "This is my comment for this store.");
	}
	
	
	public static Properties loadProperties() {
		return p;
	}
}
