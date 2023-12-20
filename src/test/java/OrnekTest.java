import Libraries.BaseClass;
import Pages.OrnekPage;
import Utils.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import static Libraries.TestUtils.getTextFromElement;
import static org.junit.Assert.assertThat;

public class OrnekTest extends BaseClass {

    public static String firstBalance;
    public static String lastBalance;
    public static String[] balance1 = { "1", "2", "3", "4", "5"};

    public static void main(String[] args) throws SQLException, IOException, ParseException {
        OrnekTestMethodu();
    }

    public static void OrnekTestMethodu() throws IOException, ParseException, SQLException {


        int[] values = Arrays.stream(balance1)
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(Arrays.toString(values));


    }


}
