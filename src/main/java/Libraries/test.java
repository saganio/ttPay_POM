package Libraries;

import java.sql.SQLException;

import static Pages.DBQueries.GET_SEMI_AMOUNT_SQL;


public class test {

    public static void main(String[] args) throws SQLException {
        String();
    }

    public static String String() throws SQLException {
        String sql = GET_SEMI_AMOUNT_SQL;
        DBConnection dbConn = new DBConnection();
        System.out.println(dbConn.ttpayDev(sql));
        return dbConn.ttpayDev(sql);
    }
}

