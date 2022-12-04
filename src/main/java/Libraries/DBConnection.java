package Libraries;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

    private static final String DB_FILENAME = "src/test/resources/DB.properties";



    private Connection openConnection(Connection connection, String dbDriver, String dbUrl, String username, String password) {
        if (connection != null) {
            closeConnection(connection);
        }
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String ttpayDev(String sql) throws SQLException, IOException {

        Properties prop = new Properties();
        prop.load(new FileInputStream(DB_FILENAME));

        String result = "";
        String dbDriver = prop.getProperty("dbDriver");
        String dbUrl = "";
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        Connection connection = openConnection(null, dbDriver, dbUrl, username, password);
        ResultSet rs = connection.createStatement().executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
                result += rs.getString(i);
            }
        }
        connection.setAutoCommit(false);
        connection.commit();
        closeConnection(connection);
        return result;
    }
    /*
        public String queryHelper2(String sql) throws SQLException {
            String result = "";
            String dbDriver = "oracle.jdbc.OracleDriver";
            String dbUrl = "jdbc:oracle:thin:tts/tts@10.10.10.33:1521/TTSDEV1";
            String username = "tts";
            String password = "tts";

            Connection connection = openConnection(null, dbDriver, dbUrl, username, password);
            ResultSet rs = connection.createStatement().executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    result += rs.getString(i);
                }
            }

            connection.setAutoCommit(false);
            closeConnection(connection);
            return result;
        }
    */

    public String ttpayDev2(String sql) throws SQLException {
        String result = "";
        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String sql="SELECT TOP(1) [Msisdn] FROM [Payflex_Gateway_2_2_2_5].[mobil].[PrePaidOrderDeactivation]";

        String dbUrl = "jdbc:sqlserver://10.10.10.109\\MSSQL2014;databaseName=TTPAY_TEST";
        String username = "ttpayuser";
        String password = "ttpaytest";


        Connection connection = openConnection(null, dbDriver, dbUrl, username, password);
        ResultSet rs = connection.createStatement().executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
                result += rs.getString(i);
            }
        }
        connection.setAutoCommit(false);
        connection.commit();
        closeConnection(connection);
        return result;
    }

}
