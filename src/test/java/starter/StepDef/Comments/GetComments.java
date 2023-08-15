package starter.StepDef.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Comments.CommentsCookitAPI;
import starter.Cookit.Recipes.RecipesCookitAPI;
import starter.Utils.Constants;

import java.io.File;

public class GetComments {
    @Steps
    CommentsCookitAPI commentsCookitAPI;
    @Given("Get Comments with valid id {int}")
    public void getCommentsWithValidIdAndPage(int ID) {
        commentsCookitAPI.setGetCommentsValid(ID);
    }

    @When("Send request get Comments with valid path")
    public void sendRequestGetCommentsWithValidPath() {
        SerenityRest.when().get(CommentsCookitAPI.GET_COMMENTS_VALID);
    }
    @And("Validate get Comments Valid json schema")
    public void validateGetCommentsValidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Comments/GetCommentsValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));

    }

    @Given("Get Comments with invalid param id {string}")
    public void getCommentsWithInvalidParamId(String ID) {
        commentsCookitAPI.setGetCommentsInvalid(ID);
    }

    @When("Send request get Comments with invalid path")
    public void sendRequestGetCommentsWithInvalidPath() {
        SerenityRest.when().get(CommentsCookitAPI.GET_COMMENTS_INVALID);
    }

    @And("Validate get Comments inValid json schema")
    public void validateGetCommentsInValidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Comments/GetCommentsInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
