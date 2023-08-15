package starter.StepDef.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Auth.Auth;
import starter.Utils.Constants;

import java.io.File;

public class StepDef {
    @Steps
    Auth auth;
    @Given("Post create register with valid json")
    public void postANewUsers() {
        File json = new File(Constants.JSON_REQ_BODY + "/Auth/RegisterReqBody.json");
        auth.postCreateUser(json);
    }
    @When("Send post create")
    public void sendPostCreateUser() {
        SerenityRest.when().post(Auth.POST_CREATE_USER);
    }
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @And("Validate create new user JSON Schema")
    public void validateGetCreateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA + "Auth/PostUserRegistrationPositive.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post create register with blank parameter")
    public void postCreateRegisterWithBlankParameter() {
        File jsonRequest = new File(Constants.JSON_REQ_BODY+"/Auth/InvalidRegister.json");
        auth.setPostLoginUtama(jsonRequest);
    }
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int not) {
        SerenityRest.then().statusCode(not);
    }

    @And("Validate create new user invalid JSON Schema")
    public void validateCreateNewUserInvalidJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Auth/InvalidRegisterNegatif.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Post login with valid and complete JSON body")
    public void postLoginWithValidAndCompleteJSONBody() {
        File json = new File(Constants.JSON_REQ_BODY+"/Auth/LoginReqBody.json");
        auth.postLogin(json);
    }
    @When("Send POST request for login")
    public void sendPOSTRequestForLogin() {
        SerenityRest.when().post(Auth.POST_LOGIN);
    }
    @Then("API response should return {int} OK")
    public void apiResponseShouldReturnOKStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Validate Message JSON Schema")
    public void validateMessageJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/Auth/PostLogin.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
