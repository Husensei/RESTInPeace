package stepDefinition;

import io.cucumber.java.en.Given;
import pages.ApiPage;

public class ApiStepDefinition {
    ApiPage apiPage;

    public ApiStepDefinition() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare valid URL to get list data")
    public void prepareValidURLToGetListData() {
        apiPage.prepareURL();
    }
}
