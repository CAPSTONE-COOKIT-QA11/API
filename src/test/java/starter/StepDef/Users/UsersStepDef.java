package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Admin.Admin;
import starter.Cookit.Auth.Auth;
import starter.Cookit.Users.Users;
import starter.Utils.Constants;

import java.io.File;
import java.io.InputStream;

import static org.hamcrest.Matchers.equalTo;

public class UsersStepDef {
    @Steps
    Users users;

    @Given("Get Users Login")
    public void getUsersLogin() {
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @When("Send request GET")
    public void sendRequestGET() {
        SerenityRest.when().get(Users.USER);
    }

    @And("Validate Message JSONSchemaa")
    public void validateMessageJSONSchemaa() {
        File json = new File(Constants.JSON_SCHEMA + "/Users/GETListUsers.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("{string} as valid username path for get user by username with valid username path")
    public void asValidUsernamePathForGetUserByUsernameWithValidUsernamePath(String user) {
        users.getUserByIdPositive(user);
    }

    @When("Send GET request Search")
    public void sendGETRequestSearch() {
        SerenityRest.when().get(Users.USER);
    }

    @And("Validate response body JSON Schema")
    public void validateResponseBodyJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Users/PUTusers.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("GET Search Users with blank parameter")
    public void getSearchUsersWithBlankParameter() {
        File json = new File(Constants.JSON_REQ_BODY + "/Users/GETblankUser.json");
        users.getUser(json);
    }

    @Then("API response should return {int} Not Found")
    public void apiResponseShouldReturnNotFound(int not) {
        SerenityRest.then().statusCode(not);
    }

    @When("Send GET Search request")
    public void sendGETSearchRequest() {
        SerenityRest.when().get(Users.SEARCH);
    }

    @Given("PUT users with valid parameter")
    public void putUsersWithValidParameter() {
        File json = new File(Constants.JSON_REQ_BODY + "/Users/PUTuser.json");
        users.setPutUsers(json);
    }

    @And("API Should response PUT JSON Schema")
    public void apiShouldResponsePUTJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Users/PUTusername.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Valid path for post upgrade verified user with valid path")
    public void validPath() {
        users.postUpgradeVerifiedUserPositive();
    }

    @When("Send POST request for post upgrade verified user with valid path")
    public void sendPOST() {
        SerenityRest.when().post(Users.USER + "/upgrade");
    }

    @Then("API response for post upgrade verified user with valid path should return {int} Created status code")
    public void StatusCode(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Validate response body JSON Schema for post upgrade verified user with valid path")
    public void validateResponse() {
        File json = new File(Constants.JSON_SCHEMA + "/Users/PUTinvalid.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
    @When("send PUT request")
    public void sendPUTRequest() {
        SerenityRest.when().put(Users.USER);
    }

    @Given("put password users with valid parameter")
    public void putPasswordUsersWithValidParameter() {
        File json = new File(Constants.JSON_REQ_BODY + "/Users/PUTuserPassword.json");
        users.putPassword(json);
    }

    @When("Send request PUT")
    public void sendRequestPUT() {
        SerenityRest.when().put(Users.PASSWORD);
    }

    @And("Validate json schema")
    public void validateJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Users/PUTinvalid.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
}
