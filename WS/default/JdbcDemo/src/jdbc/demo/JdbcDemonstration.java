package jdbc.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDemonstration {	
	static Connection myConn = null;
	static Statement stmt = null;
	
	public static void main(String[] args) {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("connection.properties"));
			
			// 1) Create a connection
			String dbUrl = props.getProperty("dburl");
			String user = props.getProperty("user");
			String pass = props.getProperty("password");
			myConn = DriverManager.getConnection(dbUrl, user, pass);
						
			// 2) Create a statement
			stmt = myConn.createStatement();
			
			FetchData();
			
			//UpdateData();
			
			// InsertData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}

	}

	public static void FetchData() throws SQLException {			
		// 3) Execute query
		ResultSet rs = stmt.executeQuery("select * from student");
			
		// 4) Process the result set
		while(rs.next()) {
			System.out.println(rs.getString("first_name") + " " +
			      rs.getString("last_name"));
		}
	}
	
	public static void UpdateData() throws SQLException {
		// 3) Execute update
		int rowAffected = stmt.executeUpdate("update student set gpa = 4.0 where id = 170");		
		System.out.println("Row affected: " + rowAffected);
	}
	
	public static void InsertData() throws SQLException {
		// 3) Insert data
		stmt.executeUpdate("insert into student values(999, 'Stephen', 'Rook', 4.0, 1400, 4)");
	}
}
