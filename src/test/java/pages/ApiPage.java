package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.getListUsers;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {
    String setURL;

    Response res;

    public void prepareURLFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setURL = Endpoint.DELETE_USERS;
                break;
            default:
                System.out.println("Input valid URL");
        }
        System.out.println("Endpoint : " + setURL);
    }

    public void hitApiGETListUsers() {
        res = getListUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationStatusCodeIsEqualsTo(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGETListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.getFirst()).isNotNull();
        assertThat(name.getFirst()).isNotNull();
        assertThat(email.getFirst()).isNotNull();
        assertThat(gender.getFirst()).isIn("male", "female");
        assertThat(status.getFirst()).isIn("active", "inactive");
    }

    public void validationResponseJSONWithJSONSchema(String filename) {
        File JSONFile = Utility.getJSONSchemaFile(filename);
        System.out.println(JSONFile);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
}
