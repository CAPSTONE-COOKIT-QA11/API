package starter.StepDef.Followers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Auth.Auth;
import starter.Cookit.Followers.Follow;
import starter.Utils.Constants;

import java.io.File;

public class FollowStepDef {
    @Steps
    Follow follow;
    @Given("Post follow user with valid {string}")
    public void postFollowUserWithValid(String id) {
        follow.postFollowUserPositive(id);
    }
    @When("Send request POST")
    public void sendRequestPOST() {
        SerenityRest.when().post(Follow.USER + Follow.idUserToFollow);

    }

    @And("API Should response POST JSON Schema")
    public void apiShouldResponsePOSTJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Auth/PostUserRegistrationPositive.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    @Given("Post follow user with invalid {string}")
    public void postFollowUserWithInvalid(String id) {
        follow.postFollowUserPositive(id);
    }

    @Then("Status code should {int} Created")
    public void statusCodeShouldCreated(int create) {
        SerenityRest.then().statusCode(create);
    }

    @Given("Delete follow user with valid {string}")
    public void deleteFollowUserWithValid(String id) {
        follow.postFollowUserPositive(id);
    }
}

