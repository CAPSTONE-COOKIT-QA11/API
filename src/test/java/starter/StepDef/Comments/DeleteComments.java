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

public class DeleteComments {
    @Steps
    CommentsCookitAPI commentsCookitAPI;
    @Given("Delete comments with valid param and body recipes {int} comments {int}")
    public void deleteCommentsWithValidParamAndBodyRecipesComments(int ID, int id) {
        commentsCookitAPI.setDeleteComments(ID, id);
    }

    @When("Send request delete comments")
    public void sendRequestDeleteComments() {
        SerenityRest.when().delete(CommentsCookitAPI.DELETE_COMMENTS);
    }

    @And("Validate json schema Delete comments valid")
    public void validateJsonSchemaDeleteCommentsValid() {
        File json = new File(Constants.JSON_SCHEMA + "/Comments/DeleteCommentsValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate json schema Delete comments invalid")
    public void validateJsonSchemaDeleteCommentsInvalid() {
        File json = new File(Constants.JSON_SCHEMA + "/Comments/DeleteCommentsInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
