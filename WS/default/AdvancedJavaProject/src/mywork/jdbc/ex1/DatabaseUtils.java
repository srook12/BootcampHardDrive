package mywork.jdbc.ex1;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import data.ResourceLocator;

public class DatabaseUtils {
	private DatabaseUtils(){}
	public static Connection getDBConnection(){
	    try {
	    	//Load the database driver
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			
			//Build URL to connect to database
			URL dbURL = ResourceLocator.class.getResource("");
			File dbFile = new File(dbURL.getFile(), "booksdb");
			String connectionURL = "jdbc:derby://localhost:1527/" + dbFile.getAbsolutePath() + ";create=true";
			
			//create and return connection
			return DriverManager.getConnection(connectionURL);
		} catch (Exception e) {
				throw new DatabaseConfigurationException(e);
		}
	}
	static class DatabaseConfigurationException extends RuntimeException{
		public DatabaseConfigurationException(Exception e){
			super(e);
		}
	}
}
