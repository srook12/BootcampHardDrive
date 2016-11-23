package stored.procedure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class CountSatScores {

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

		int satScore = 1000;
		int numScores;
		
		stmt = conn.prepareCall("{call get_count_for_sat(?, ?)}");
		stmt.setInt(1, satScore);
		
		stmt.registerOutParameter(2, java.sql.Types.INTEGER);
		
		stmt.execute();
		
		numScores = stmt.getInt(2);
		
		System.out.println("The number of students with an SAT score of " + satScore + " is " + numScores);
		
	}

}
