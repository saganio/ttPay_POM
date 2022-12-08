package Libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static Pages.DBQueries.*;

public class DBConnection {

    private static final String DB_FILENAME = "src/test/resources/DB.properties";


    public static void main(String[] args) throws SQLException, IOException {
        String sql = SET_SEMIVERIFIED_OTP_SQL;
        DBConnection dbConnection = new DBConnection();

        dbConnection.ttpayDev2(sql);
        System.out.println(dbConnection.ttpayDev2(sql));


    }

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
        String dbUrl = prop.getProperty("dbUrl");
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

    public String ttpayDev2(String sql) throws SQLException, IOException {

        Properties prop = new Properties();
        FileInputStream in = new FileInputStream(DB_FILENAME);
        prop.load(in);
        in.close();

        String result = "";
        String dbDriver = prop.getProperty("dbDriver");
        //String sql="SELECT TOP(1) [Msisdn] FROM [Payflex_Gateway_2_2_2_5].[mobil].[PrePaidOrderDeactivation]";
        String dbUrl = prop.getProperty("dbUrl");
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

}
