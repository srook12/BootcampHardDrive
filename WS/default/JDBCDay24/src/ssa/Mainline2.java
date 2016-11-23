package ssa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mainline2 {

	private static Connection conn = null;
	
	public static void main(String[] args) throws SQLException {
		String host = "jdbc:mysql://sql9.freesqldatabase.com:3306";
		String user = "sql9139042";
		String passwd = "ldVDkSaZF2";
		conn = DriverManager.getConnection(host, user, passwd);
		System.out.println("Here?");
		String sql = "select * from major";
		
		
		
		conn.close();

	}

}
