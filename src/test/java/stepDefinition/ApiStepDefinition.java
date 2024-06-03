package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStepDefinition {

    ApiPage apiPage;

    public ApiStepDefinition() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare URL for {string}")
    public void prepareURLFor(String url) {
        apiPage.prepareURLFor(url);
    }

    @And("hit api GET list users")
    public void hitApiGETListUsers() {
        apiPage.hitApiGETListUsers();
    }

    @Then("validation status code is equal to {int}")
    public void validationStatusCodeIsEqualsTo(int status_code) {
        apiPage.validationStatusCodeIsEqualsTo();
    }

    @Then("validation response body GET list users")
    public void validationResponseBodyGETListUsers() {
        apiPage.validationResponseBodyGETListUsers();
    }

    @Then("validation response JSON with JSONSchema {string}")
    public void validationResponseJSONWithJSONSchema(String filename) {
        apiPage.validationResponseJSONWithJSONSchema();
    }
}
