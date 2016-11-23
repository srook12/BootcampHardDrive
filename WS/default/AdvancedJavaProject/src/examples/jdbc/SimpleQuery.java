package examples.jdbc;
import java.sql.*;
public class SimpleQuery {
    public static void main(String args[]) {
        try {
            Connection con = DatabaseUtils.getDBConnection();
            // Create and send statement
            String query = "SELECT Author,Title, " +
                    "NumPages FROM BOOKS";
            Statement stmt = con.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            // Process data
            String author, title;
            int pages;
            while (rslt.next()) {
                author = rslt.getString("Author");
                title = rslt.getString("Title");
                pages = rslt.getInt("NumPages");
                System.out.println(title + " by " +
                    author + " has " + pages +
                    " pages.");
            }
            // Cleanup
            rslt.close();
            stmt.close();
            con.close();
        } catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
}