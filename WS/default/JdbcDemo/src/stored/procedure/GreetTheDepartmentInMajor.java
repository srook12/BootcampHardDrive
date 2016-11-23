package stored.procedure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class GreetTheDepartmentInMajor {
	
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

		String description = "Computer Science";
		
		stmt = conn.prepareCall("{call greet_the_student_in_major(?)}");
		
		// Register the returned String as a varchar
		stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
		stmt.setString(1, description);
		
		System.out.println("Calling the stored procedure");
		stmt.execute();
		
		// Pull out the changed value of description
		System.out.println(stmt.getString(1));
		
		stmt.close();
		conn.close();
	}

}
