package pages;

import helper.Endpoint;

public class ApiPage {
    String setURL;

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
        System.out.println("2nd step from page");
    }

    public void validationStatusCodeIsEqualsTo() {
        System.out.println("3rd step from page");
    }

    public void validationResponseBodyGETListUsers() {
        System.out.println("4th step from page");
    }

    public void validationResponseJSONWithJSONSchema() {
        System.out.println("5th step from page");
    }
}
