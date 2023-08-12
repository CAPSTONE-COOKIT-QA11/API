package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Auth.Auth;
import starter.Cookit.Users.Users;
import starter.Utils.Constants;

import java.io.File;

public class UsersStepDef {
    @Steps
    Users users;
    @Given("Get Users Login")
    public void getUsersLogin() {
        SerenityRest.given().headers("Authorization", "Bearer "+ Constants.BEARER_TOKEN);
    }

    @When("Send request GET")
    public void sendRequestGET() {
        SerenityRest.when().get(Users.USERS);
    }

    @And("Validate Message JSONSchemaa")
    public void validateMessageJSONSchemaa() {
        File json = new File(Constants.JSON_SCHEMA + "/Users/GETListUsers.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("PUT Users with valid parameter")
    public void putUsersWithValidParameter() {
        SerenityRest.given().headers("Authorization", "Bearer "+ Constants.BEARER_TOKEN);
    }

    @When("Send request PUT")
    public void sendRequestPUT() {
        SerenityRest.when().get(Users.USERS);
    }

    @And("Validate Message PUT Users JSONSchema")
    public void validateMessagePUTUsersJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Users/PUTusers.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("PUT Users with blank parameter")
    public void putUsersWithBlankParameter() {
        SerenityRest.given().headers("Authorization", "Bearer "+ Constants.BEARER_TOKEN);
    }
    
    @Given("{string} as valid username path for get user by username with valid username path")
    public void asValidUsernamePathForGetUserByUsernameWithValidUsernamePath(String user) {
        users.getUserByIdPositive(user);
    }

    @When("Send GET request Search")
    public void sendGETRequestSearch() {
        SerenityRest.when().get(Users.USERS);
    }

    @And("Validate response body JSON Schema")
    public void validateResponseBodyJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Users/PUTusers.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
