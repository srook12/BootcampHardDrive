package stored.procedure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class IncreaseGpaForStudents {
	static Properties properties = null;
	
	static {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("connection.properties"));		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		CallableStatement stmt = null;

		String url = properties.getProperty("dburl");
		String user = properties.getProperty("user");
		String pass = properties.getProperty("password");
		
		conn = DriverManager.getConnection(url, user, pass);
		
		int satThreshold = 1000;
		double increase = 0.20;
		
		// Show before
		System.out.println("Gpa values Before");
		showSat(conn, satThreshold);
		
		// Prepare the stored procedure call
		stmt = conn.prepareCall("{call increase_gpa_for_sat(?, ?)}");
		stmt.setInt(1, satThreshold);
		stmt.setDouble(2, increase);
		
		// Called stored procedure
		System.out.println("\n\nCalling stored procedure");
		stmt.execute();
		System.out.println("Finished calling the stored procedure");
		
		// Show after
		showSat(conn, satThreshold);
		
		conn.close();
	}

	private static void showSat(Connection conn, int satThreshold) throws Exception{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		stmt = conn.prepareStatement("select * from student where sat > ?");
		stmt.setInt(1, satThreshold);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(String.format("%-20s  %-20s  %6d  %5.2f", 
					rs.getString("first_name"), rs.getString("last_name"),
					rs.getInt("sat"), rs.getDouble("gpa")));
		}
		
		stmt.close();
	}
}
