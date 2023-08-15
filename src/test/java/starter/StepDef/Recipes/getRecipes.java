package starter.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Recipes.RecipesCookitAPI;
import starter.Utils.Constants;

import java.io.File;


public class getRecipes {
    @Steps
    RecipesCookitAPI recipesCookitAPI;

    @Given("Get recipes with valid path")
    public void getRecipesWithValidPath() {
        recipesCookitAPI.setGetRecipes();
    }

    @When("Send request get recipes with valid path")
    public void sendRequestGetRecipesWithValidPath() {
        SerenityRest.when().get(RecipesCookitAPI.GET_RECIPES);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate get recipes json schema")
    public void validateGetRecipesJsonSchema() {
    }
    @Given("Get recipes with invalid path")
    public void getRecipesWithInvalidPath() {
        recipesCookitAPI.setGetRecipes();
    }

    @When("Send request get recipes with invalid path")
    public void sendRequestGetRecipesWithInvalidPath() {
        SerenityRest.when().get(RecipesCookitAPI.GET_RECIPES_INVALID);
    }

    @And("Validate get recipes invalid json schema")
    public void validateGetRecipesInvalidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/GetRecipesInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
