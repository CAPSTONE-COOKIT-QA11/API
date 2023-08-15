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

public class GetTrending {

    @Steps
    RecipesCookitAPI recipesCookitAPI;
    @Given("Get Trending with valid path")
    public void getTrendingWithValidPath() {
        recipesCookitAPI.setGetTrendingValidPath();
    }

    @When("Send request get trending with valid path")
    public void sendRequestGetTrendingWithValidPath() {
        SerenityRest.when().get(RecipesCookitAPI.GET_TRENDING_VALID_PATH);
    }

    @And("Validate get trending json schema")
    public void validateGetTrendingJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/GetTrendingValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get Trending with param {int}")
    public void getTrendingWithParam(int id) {
        recipesCookitAPI.setGetTrendingWithParam(id);
    }

    @When("Send request get trending with param")
    public void sendRequestGetTrendingWithInvalidParam() {
        SerenityRest.when().get(RecipesCookitAPI.GET_TRENDING_WITH_PARAM);
    }

    @And("Validate get trending with param json schema")
    public void validateGetTrendingInvalidParamJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/GetTrendingWithParamSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
