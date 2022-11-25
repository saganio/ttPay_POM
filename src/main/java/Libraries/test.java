package Libraries;

import java.sql.SQLException;

import static Pages.DBQueries.SET_VERIFIED_OTP_SQL;


public class test {

    public static void main(String[] args) throws SQLException {
        String();
    }

    public static String String() throws SQLException {
        String sql = SET_VERIFIED_OTP_SQL;
        DBConnection dbConn = new DBConnection();
        System.out.println(dbConn.ttpayDev(sql));
        return dbConn.ttpayDev(sql);
    }
}

