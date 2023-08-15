package starter.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Recipes.RecipesCookitAPI;

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
}
