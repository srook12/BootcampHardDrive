package theironyard;

import java.io.FileReader;
import java.util.Properties;

public class PropDemo {
	
	public static final String HERO_PROP = "vg.hero";
	public static final String VILLAIN_PROP = "vg.villain";
	public static final String SEPARATOR = "---------------";
	
	public static void main(String args[]) throws Exception {
		   
		  FileReader fr = new FileReader("vg.properties"); 
		   
	      Properties vgProps = new Properties();
	      
	      vgProps.load(fr);
	      
	      System.out.printf("%-15s %-15s\n", "Hero", "Villain");
	      System.out.println(SEPARATOR + " " + SEPARATOR);
	      
	      for(int i = 1; i <= 4; i++) {
	    	  System.out.printf("%-15s %-15s\n", vgProps.getProperty(HERO_PROP + i), vgProps.getProperty(VILLAIN_PROP + i));
	      }
	      
	      
	}
}
