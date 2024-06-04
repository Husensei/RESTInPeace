package pages;

import helper.Endpoint;
import helper.Models;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {
    String setURL, globalId;
    Response res;
    int userId = 6943005;

    public void prepareURLFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "GET_SPECIFIC_USERS":
                setURL = Endpoint.GET_SPECIFIC_USERS;
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
    }

    public void hitApiGETListUsers() {
        res = Models.getListUsers(setURL);
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
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitApiPOSTNewUser() {
        res = Models.postNewUsers(setURL);
    }

    public void validationResponseBodyPOSTNewUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("male", "female");
        assertThat(status).isIn("active", "inactive");

        globalId = Integer.toString(id);
    }

    public void hitApiDELETEUser() {
        res = Models.deleteUser(setURL, globalId);
    }
}
