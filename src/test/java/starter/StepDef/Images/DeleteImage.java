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

public class DeleteImage {
    @Steps
    ImageCookitAPI imageCookitAPI;
    @Given("Delete image with valid id recipe {int}")
    public void deleteImageWithValidIdRecipe(int recipe_id) {
        imageCookitAPI.setDeleteImageValid(recipe_id);
    }

    @When("Send Delete image")
    public void sendDeleteImage() {
        SerenityRest.when().delete(ImageCookitAPI.DELETE_IMAGE_VALID);
    }

    @And("Validate json schema Delete image valid")
    public void validateJsonSchemaDeleteImageValid() {
        File json = new File(Constants.JSON_SCHEMA + "/Images/DeleteImagesSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete image with invalid id recipe {int}")
    public void deleteImageWithInvalidIdRecipe(int recipe_id) {
        imageCookitAPI.setDeleteImageValid(recipe_id);
    }

    @And("Validate json schema Delete image invalid")
    public void validateJsonSchemaDeleteImageInvalid() {
        File json = new File(Constants.JSON_SCHEMA + "/Images/DeleteImagesSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete image with valid recipe id {int} and valid image id {int}")
    public void deleteImageWithValidRecipeIdAndValidImageId(int recipe_id, int image_id) {
        imageCookitAPI.setDeleteImageTwoParam(recipe_id, image_id);
    }

    @When("Send Delete image two param")
    public void sendDeleteImageTwoParam() {
        SerenityRest.when().delete(ImageCookitAPI.DELETE_IMAGE_TWO_PARAM);
    }

    @And("Validate json schema Delete image invalid param id")
    public void validateJsonSchemaDeleteImageInvalidParamId() {
        File json = new File(Constants.JSON_SCHEMA + "/Images/DeleteImagesSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete image with valid recipe id {int} and invalid image id {int}")
    public void deleteImageWithValidRecipeIdAndInvalidImageId(int recipe_id, int image_id) {
        imageCookitAPI.setDeleteImageTwoParam(recipe_id, image_id);
    }
}
