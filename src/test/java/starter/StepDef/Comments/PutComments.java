package starter.StepDef.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Comments.CommentsCookitAPI;
import starter.Utils.Constants;

import java.io.File;

public class PutComments {
    @Steps
    CommentsCookitAPI commentsCookitAPI;
    @Given("Put Comments with id {int} comment id {int}")
    public void putCommentsWithIdCommentId(int ID, int id) {
        File JsonRequest = new File(Constants.JSON_REQ_BODY+"/Comments/PutCommentsValid.json");
        commentsCookitAPI.setPutCommentsValid(ID, id,JsonRequest);
    }

    @When("Send request put comments")
    public void sendRequestPutComments() {
        SerenityRest.when().put(CommentsCookitAPI.PUT_COMMENTS_VALID);
    }

    @And("Validate put Comments Valid json schema")
    public void validatePutCommentsValidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Comments/PutCommentsValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate put Comments Invalid json schema")
    public void validatePutCommentsInvalidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Comments/PutCommentsInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
