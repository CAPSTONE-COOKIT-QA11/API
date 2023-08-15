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

public class GetRecipesDetail {
    @Steps
    RecipesCookitAPI recipesCookitAPI;
    @Given("Get recipes detail with valid path id {int}")
    public void getRecipesDetailWithValidPath(int id) {
        recipesCookitAPI.setGetRecipesDetailValid(id);
    }

    @When("Send request get recipes detail with valid path")
    public void sendRequestGetRecipesDetailWithValidPath() {
        SerenityRest.when().get(RecipesCookitAPI.GET_RECIPES_DETAIL_VALID);
    }

    @And("Validate get recipes detail json schema")
    public void validateGetRecipesDetailJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/GetRecipesDetailValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Get recipes detail with invalid param id {string}")
    public void getRecipesDetailWithInvalidParamId(String id) {
        recipesCookitAPI.setGetRecipesDetailInvalid(id);
    }

    @When("Send request get recipes detail with invalid para")
    public void sendRequestGetRecipesDetailWithInvalidPara() {
        SerenityRest.when().get(RecipesCookitAPI.GET_RECIPES_DETAIL_INVALID);
    }

    @And("Validate get recipes detail invalid param json schema")
    public void validateGetRecipesDetailInvalidParamJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/GetRecipesDetailInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
