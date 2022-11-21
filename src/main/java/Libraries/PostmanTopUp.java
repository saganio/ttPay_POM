package Libraries;

import okhttp3.*;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import static Libraries.BaseClass.getString;

public class PostmanTopUp {

    private static final String GET_TOKEN_URL = "http://172.26.66.222:9000/account-provider/oauth/token?grant_type=client_credentials";
    private static final String MAKE_TOPUP_URL = "http://172.26.66.222:9000/thirdparty-api/v1/topup";

    public static void main(String[] args) throws IOException, ParseException {
        getToken_MakeTopUp(getString("id"), getString("amount"));

    }

    public static void getToken_MakeTopUp(String msisdn, String amount) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(GET_TOKEN_URL)
                .method("POST", body)
                .addHeader("Authorization", "Basic dGhpcmRwYXJ0eS1hcGk6c2VjcmV0")
                .build();
        Response response = client.newCall(request).execute();

        String resStr = response.body().string();
        JSONObject json = new JSONObject(resStr);
        String getToken = json.getString("access_token");
        System.out.println("Token alındı: " + getToken);


        OkHttpClient client1 = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType1 = MediaType.parse("application/json");
        RequestBody body1 = RequestBody.create(mediaType1, "{\n"
                                                           + "\"detail\":{\n"
                                                           + "\"application\":{\n"
                                                           + "\"applicationId\":\"00000000-0000-0000-0000-000000000000\",\n"
                                                           + "\"userId\":\"a6de587e-9ac6-4edb-aaa7-6bbfaeee7609\",\n"
                                                           + "\"version\":\"0.33.24\"\n"
                                                           + "},\n"
                                                           + "\n"
                                                           + "\"msisdn\":" + "90" + msisdn + ",\n"
                                                           + "\"channel\":\"BYS_TOPUPP\",\n"
                                                           + "\"originatorInstitutionId\":\"BYS_TOPUP\",\n"
                                                           + "\"originatorInstitutionName\":\"BYS_TOPUP\",\n"
                                                           + "\"originatorUserId\":\"BYS_TOPUP\",\n"
                                                           + "\"amount\":" + amount + "\n"
                                                           + "},\n"
                                                           + "\"header\":{\n"
                                                           + "\"system\":\"TTPAY_MOBIL\",\n"
                                                           + "\"transactionId\":\"5a0f2e06-26b3-43ab-b991-0fd5e8f61834\"\n"
                                                           + "}\n"
                                                           + "}");


        Request request1 = new Request.Builder()
                .url(MAKE_TOPUP_URL)
                .method("POST", body1)
                .addHeader("Authorization", "Bearer" + getToken)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response1 = client1.newCall(request1).execute();

        String str = response1.body().string();
        JSONObject json1 = new JSONObject(str);
        System.out.println(json1);

    }

}
