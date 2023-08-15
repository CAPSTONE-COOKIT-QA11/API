package starter.StepDef.Images;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Images.ImageCookitAPI;
import starter.Cookit.Steps.StepsCookitAPI;
import starter.Utils.Constants;

import java.io.File;

public class PostImage {
    @Steps
    ImageCookitAPI imageCookitAPI;
    @Given("Post image with valid id recipe {int}")
    public void postImageWithValidIdRecipe(int recipe_id) {
        imageCookitAPI.setPostImageValidId(recipe_id);
    }
    @When("Send post image")
    public void sendPostImage() {
        SerenityRest.when().post(ImageCookitAPI.POST_IMAGE_VALID_ID);
    }
    @And("Validate json schema post image valid")
    public void validateJsonSchemaPostImageValid() {
        File json = new File(Constants.JSON_SCHEMA + "/Images/PostImagesSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
    @Given("Send post image without file with valid id recipe {int}")
    public void sendPostImageWithoutFileWithValidIdRecipe(int recipe_id) {
        imageCookitAPI.setPostImageWithoutFile(recipe_id);
    }

    @When("Send post image without file")
    public void sendPostImageWithoutFile() {
        SerenityRest.when().post(ImageCookitAPI.POST_IMAGE_VALID_ID);
    }

    @Then("Status code should be {int} an unknown error")
    public void statusCodeShouldBeAnUnknownError(int unknownError) {
        SerenityRest.then()
                .statusCode(unknownError);
    }

    @Given("Post image with invalid id recipe {int}")
    public void postImageWithInvalidIdRecipe(int recipe_id) {
        imageCookitAPI.setPostImageInvalidId(recipe_id);
    }

    @And("Validate json schema post image invalid")
    public void validateJsonSchemaPostImageInvalid() {
        File json = new File(Constants.JSON_SCHEMA + "/Images/PostImagesInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
