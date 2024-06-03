package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Models {

    private static RequestSpecification request;

    public static void setUpHeaders() {
        request = RestAssured
                .given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("Authorization", "8f5976736de5afcf1469d286af2a46abcc866e843b6cc0306fd7dc60f5035206");
    }

    public static Response getListUsers(String endpoint) {
        setUpHeaders();
        return request.when().get(endpoint);
    }
}
