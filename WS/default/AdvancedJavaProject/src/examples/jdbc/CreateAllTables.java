package examples.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAllTables {
	static Connection conn = DatabaseUtils.getDBConnection();
	public static void main(String[] args) throws SQLException {
		booksTable();
		authorsTable();
		booksIITable();
		conn.close();
	}
	
	public static void booksTable() throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.execute("CREATE TABLE books (bookid INT, title VARCHAR(30), author VARCHAR(30), numpages INT)");

		stmt.executeUpdate ("INSERT INTO books VALUES (1, 'AirFrame', 'Michael Crichton', 347)");
		stmt.executeUpdate ("INSERT INTO books VALUES (2, 'Green Eggs and Ham', 'Dr. Seuss', 62)");
		stmt.executeUpdate ("INSERT INTO books VALUES (3, 'The Vampire Lestat', 'Anne Rice', 550)");
		stmt.executeUpdate ("INSERT INTO books VALUES (4, 'Chaos: Making a New Science', 'James Gleick', 317)");
		stmt.close();
	}
	
	public static void authorsTable() throws SQLException {
		
		Statement stmt = conn.createStatement();
		stmt.execute("CREATE TABLE authors (authorid INT, author VARCHAR(30))");
		stmt.executeUpdate ("INSERT INTO authors VALUES (1, 'Michael Crichton')");
		stmt.executeUpdate ("INSERT INTO authors VALUES (2, 'Dr. Seuss')");
		stmt.executeUpdate ("INSERT INTO authors VALUES (3, 'Anne Rice')");
		stmt.executeUpdate ("INSERT INTO authors VALUES (4, 'James Gleick')");
		stmt.executeUpdate ("INSERT INTO authors VALUES (5, 'John Grisham')");
		stmt.executeUpdate ("INSERT INTO authors VALUES (6, 'Heinlein')");

		stmt.close();
	}

	public static void booksIITable() throws SQLException {
		
		Statement stmt = conn.createStatement();
		stmt.execute("CREATE TABLE books_II (bookid INT, authorid INT, title VARCHAR(30), numpages INT)");
		stmt.executeUpdate ("INSERT INTO books_II VALUES (1, 1, 'AirFrame', 347)");
		stmt.executeUpdate ("INSERT INTO books_II VALUES (2, 2, 'Green Eggs and Ham', 62)");
		stmt.executeUpdate ("INSERT INTO books_II VALUES (3, 3, 'The Vampire Lestat', 550)");
		stmt.executeUpdate ("INSERT INTO books_II VALUES (4, 4, 'Chaos: Making a New Science', 317)");
		stmt.executeUpdate ("INSERT INTO books_II VALUES (5, 5, 'The Firm', 501)");
		stmt.executeUpdate ("INSERT INTO books_II VALUES (6, 6, 'To Sail Beyond The Sunset', 425)");

		stmt.close();
	}
}
