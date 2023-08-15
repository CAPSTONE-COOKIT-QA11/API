package starter.StepDef.Images;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Images.ImageCookitAPI;
import starter.Utils.Constants;

import java.io.File;

public class PutImages {
    @Steps
    ImageCookitAPI imageCookitAPI;
    @Given("Put image with valid id recipe {int} and image {int}")
    public void putImageWithValidIdRecipeAndImage(int recipe_id, int image_id) {
        imageCookitAPI.setPutImageValidId(recipe_id,image_id);
    }

    @When("Send Put image")
    public void sendPutImage() {
        SerenityRest.when().put(ImageCookitAPI.PUT_IMAGE_VALID_ID);
    }

    @And("Validate json schema post image valid id")
    public void validateJsonSchemaPostImageValidId() {
        File json = new File(Constants.JSON_SCHEMA + "/Images/PutImagesValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put image with valid id recipe {int} and invalid image id {int}")
    public void putImageWithValidIdRecipeAndInvalidImageId(int recipe_id, int image_id) {
        imageCookitAPI.setPutImageValidId(recipe_id,image_id);
    }

    @And("Validate json schema post image invalid id")
    public void validateJsonSchemaPostImageInvalidId() {
        File json = new File(Constants.JSON_SCHEMA + "/Images/PutImagesInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put image without file with valid recipe id {int} and invalid image id {int}")
    public void putImageWithoutFileWithValidRecipeIdAndInvalidImageId(int recipe_id, int image_id) {
        imageCookitAPI.setPutImageWithoutFile(recipe_id,image_id);
    }

    @And("Validate json schema post image invalid param id")
    public void validateJsonSchemaPostImageInvalidParamId() {
        File json = new File(Constants.JSON_SCHEMA + "/Images/PutImagesInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
