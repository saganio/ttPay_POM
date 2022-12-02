package Libraries;
import java.sql.*;

public class DBConnection {


    public static void main(String[] args) throws SQLException {
        String sql = "SELECT TOP (1) c.ACCOUNT_BALANCE\n"
                     + "FROM [TTPAY_TEST].[dbo].[ACC_USER] a,\n"
                     + "[TTPAY_TEST].[dbo].[EMN_MEMBER] b,\n"
                     + "[TTPAY_TEST].[dbo].[EMN_MEMBER_DETAIL_LOG] c\n"
                     + "WHERE a.USER_ID = b.USER_ID\n"
                     + "AND b.MEMBER_CODE = c.MEMBER_CODE\n"
                     + "AND a.ACTIVE_MSISDN = '905997654321'\n"
                     + "ORDER BY c.CREATED_DATE DESC";


                DBConnection dbConn = new DBConnection();
        System.out.println(dbConn.ttpayDev2(sql));
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

    public String ttpayDev(String sql) throws SQLException {
        String result = "";
        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String sql="SELECT TOP(1) [Msisdn] FROM [Payflex_Gateway_2_2_2_5].[mobil].[PrePaidOrderDeactivation]";
        String dbUrl = "jdbc:sqlserver://;servername=172.26.66.235;encrypt=true;trustServerCertificate=true;";
        String username = "TTPAY_TEST";
        String password = "2kq43W!5Mb";

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
