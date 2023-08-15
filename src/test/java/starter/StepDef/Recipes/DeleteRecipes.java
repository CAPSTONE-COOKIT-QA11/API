package starter.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Recipes.RecipesCookitAPI;
import starter.Utils.Constants;

import java.io.File;

public class DeleteRecipes {
    @Steps
    RecipesCookitAPI recipesCookitAPI;

    @Given("Delete recipes with valid param id {int}")
    public void deleteRecipesWithValidParamId(int id) {
       recipesCookitAPI.setDeleteRecipesValidParam(id);
    }

    @When("Send request Delete recipes with valid path")
    public void sendRequestDeleteRecipesWithValidPath() {
        SerenityRest.when().delete(RecipesCookitAPI.DELETE_RECIPES_VALID_PARAM);
    }

    @And("Validate delete recipes valid json schema")
    public void validateDeleteRecipesValidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/DeleteRecipesInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete recipes with invalid param id {int}")
    public void deleteRecipesWithInvalidParamId(int recipe_id) {
        recipesCookitAPI.setDeleteRecipesInvalidParam(recipe_id);
    }

    @When("Send request Delete recipes with invalid path")
    public void sendRequestDeleteRecipesWithInvalidPath() {
        SerenityRest.when().delete(RecipesCookitAPI.DELETE_RECIPES_INVALID_PARAM);
    }

    @And("Validate delete recipes invalid json schema")
    public void validateDeleteRecipesInvalidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/DeleteRecipesInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
