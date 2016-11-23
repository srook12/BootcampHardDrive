package jdbc.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class SamplePreparedStatement {

	public static Connection conn = null;
	public static PreparedStatement pState = null;
	public static ResultSet rs = null;
	
	public static void main(String[] args) {
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream("connection.properties"));
			String url = properties.getProperty("dburl");
			String user = properties.getProperty("user");
			String pass = properties.getProperty("password");
			conn = DriverManager.getConnection(url, user, pass);

			pState = conn.prepareStatement("select * from student where gpa > ? and sat > ?");
			pState.setDouble(1, 2.0);
			pState.setInt(2, 1000);
			rs = pState.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") 
				+ " " + rs.getDouble("gpa") + " " + rs.getInt("sat"));
			}
			
		} catch (Exception ex) {
			
		} finally {
			
		}
	}

}
