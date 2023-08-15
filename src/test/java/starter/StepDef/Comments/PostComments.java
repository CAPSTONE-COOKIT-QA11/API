package starter.StepDef.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Comments.CommentsCookitAPI;
import starter.Cookit.Recipes.RecipesCookitAPI;
import starter.Utils.Constants;

import java.io.File;

public class PostComments {
    @Steps
    CommentsCookitAPI commentsCookitAPI;
    @Given("POST Comments with valid id {int}")
    public void postCommentsWithValidId(int id) {
        File JsonRequest = new File(Constants.JSON_REQ_BODY+"/Comments/PostCommentsValid.json");
        commentsCookitAPI.setPostCommentsValid(id,JsonRequest);
    }

    @When("Send request post Comments with valid path")
    public void sendRequestPostCommentsWithValidPath() {
        SerenityRest.when().post(CommentsCookitAPI.POST_COMMENTS_VALID);
    }
    @And("Validate post Comments Valid json schema")
    public void validatePostCommentsValidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Comments/PostCommentsValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("POST Comments with invalid param id {string}")
    public void postCommentsWithInvalidParamId(String id) {
        File JsonRequest = new File(Constants.JSON_REQ_BODY+"/Comments/PostCommentsInvalid.json");
        commentsCookitAPI.setPostCommentsInvalid(id,JsonRequest);
    }

    @When("Send request post Comments with invalid param")
    public void sendRequestPostCommentsWithInvalidParam() {
        SerenityRest.when().post(CommentsCookitAPI.POST_COMMENTS_INVALID);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Validate post Comments inValid json schema")
    public void validatePostCommentsInValidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Comments/PostCommentsInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
