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

public class PostRecipes {

    @Steps
    RecipesCookitAPI recipesCookitAPI;
    @Given("post Recipes with valid path")
    public void postRecipeswithValidPath() {
        File JsonReq = new File(Constants.JSON_REQ_BODY + "/Recipes/RecipesPostUser.json");
        recipesCookitAPI.setPostRecipes(JsonReq);
    }
    @When("Send request post with valid path")
    public void sendRequestPostwithValidPath() {
        SerenityRest.when().post(RecipesCookitAPI.POST_RECIPES_VALID_PATH);
    }
    @And("Validate pos recipes json schema")
    public void validatePosRecipesJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/PostRecipesSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
