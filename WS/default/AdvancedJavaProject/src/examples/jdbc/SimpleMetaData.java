package examples.jdbc;

import java.sql.*;

public class SimpleMetaData {
    public static void main(String args[]) {
        if (args.length < 1) {
            String usage = "USAGE: java " + 
               "examples.jdbc.SimpleMetaData "+
               "<tablename>";
            System.out.println(usage);
            System.exit(1);
        }
        try{
            displayInfo(args[0]);
        }catch (SQLException e) {
            StringBuffer sb = new StringBuffer();
            while (e != null) {
                sb.append("SQLState: ");
                sb.append(e.getSQLState());
                sb.append("Message:  ");
                sb.append(e.getMessage());
                sb.append("ErrorCode:   ");
                sb.append(e.getErrorCode());
                sb.append("\n");
                e = e.getNextException();
            }
            System.out.println(sb);
        }
    }
    
    public static void displayInfo(String tName)
            throws SQLException{
        String tableName = tName;

        Connection con = DatabaseUtils.getDBConnection();

        // Create and send statement
        String qry =
            "SELECT * FROM " + tableName;

        Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(qry);

        ResultSetMetaData rsmd = rslt.getMetaData();
        int colCount = rsmd.getColumnCount();

        System.out.println("Field\tType");
        System.out.println("-----\t----");
        int width, type;
        for (int i = 1; i <= colCount; i++) {
            width = rsmd.getColumnDisplaySize(i);
            String colName = rsmd.getColumnName(i);
            type = rsmd.getColumnType(i);

            String category = null;
            switch (type) {
            case Types.TINYINT:
            case Types.SMALLINT:
            case Types.INTEGER:
            case Types.BIGINT:
                category = "Integer";
                break;
            case Types.CHAR:
            case Types.VARCHAR:
                category = "Char";
                break;
            }
            System.out.print(colName + "\t" +
                               category);
            if (category.equals("Char"))
                System.out.print("(" + width + ")");
            System.out.println();
        }
        // Cleanup
        rslt.close();
        stmt.close();
        con.close();
    } 
}