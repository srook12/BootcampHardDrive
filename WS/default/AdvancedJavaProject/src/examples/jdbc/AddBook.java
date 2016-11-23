package examples.jdbc;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;

import data.ResourceLocator;

public class AddBook {
    static Connection conn;
    static Statement stmt;
    public static void main(String args[]) {
        try {
            //checkArguments(args);
            configureConnection();
            configureTransactions();
            stmt = conn.createStatement();
            // begin transaction
            conn.setAutoCommit(false);
            manipulateData(args);
            conn.commit(); // commit transaction
            // Cleanup
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void checkArguments(String args[]){
        if (args.length != 3) {
            String msg = "USAGE: java AddBook "
                + "<author> <title> <pages>";
            throw new IllegalArgumentException(msg);
        }
    }
    
    public static void configureConnection() throws
    		ClassNotFoundException, SQLException, URISyntaxException{
    	conn = DatabaseUtils.getDBConnection();
    }
    
    public static void configureTransactions()
            throws SQLException{
        DatabaseMetaData dbmd = conn.getMetaData();
        if (!dbmd.supportsTransactions()) {
            String msg = "No Transaction Support";
            throw new RuntimeException(msg);
        }
        int txLevel =
            conn.getTransactionIsolation();
        // try to set a higher TRANSACTION LEVEL
        if (txLevel == Connection.TRANSACTION_NONE) {
            int txRC =
               Connection.TRANSACTION_READ_COMMITTED;
            boolean readCommitted = dbmd.
             supportsTransactionIsolationLevel(txRC);
            if (readCommitted)
                conn.setTransactionIsolation(txRC);
        }
    }
    public static void manipulateData(String args[])
            throws SQLException{
        String sql;
        ResultSet rslt;
        try {
            // Get new AuthorId
            sql= "SELECT MAX(AuthorId) AS " + 
                 "Max_AuthorId FROM AUTHORS";
            rslt = stmt.executeQuery(sql);
            int authID = 0;
            while (rslt.next())
                authID =
                    rslt.getInt("Max_AuthorId") + 1;
            // Add to Authors
            sql = "INSERT INTO AUTHORS " +
                  "(AuthorId, Author) VALUES (" + 
                  authID + ", '" + args[0] + "')";
            stmt.executeUpdate(sql);
            // Get new BookId
            sql = "SELECT MAX(BookId) AS " +
                  "Max_BookId FROM Books_II";
            rslt = stmt.executeQuery(sql);
            int bookID = 0;
            while (rslt.next())
                bookID =
                    rslt.getInt("Max_BookId") + 1;
            // Add to Books_II
            sql = "INSERT INTO BOOKS_II " +
                "(BookId, AuthorId, Title, NumPages)"
                + " VALUES (" + bookID + ", "
                 + authID + ", '" + args[1] + "', "
                + args[2] + ")";
            stmt.executeUpdate(sql);
            
        } catch (SQLException e) {
            // rollback transaction
            conn.rollback();
            throw new SQLException(e.getMessage());
        }
    }
}