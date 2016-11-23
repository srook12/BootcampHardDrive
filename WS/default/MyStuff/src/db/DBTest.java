package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	  // This will load the MySQL driver, each DB has its own driver
	  Class.forName("com.mysql.jdbc.Driver");
	  // Setup the connection with the DB
	  Connection connect = DriverManager
	                       .getConnection("jdbc:mysql://localhost/day17?"
	                       + "user=root&password=evig1212&useSSL=false");

	  String sql = "insert into student values (301, 'Jack', 'Doff', 4.0, 1500, 4)";
	  
	  Statement statement = connect.createStatement();
	  statement.executeUpdate(sql);
	}

}
