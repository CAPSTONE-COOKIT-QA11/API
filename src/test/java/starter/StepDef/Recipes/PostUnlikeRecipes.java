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

public class PostUnlikeRecipes {
    @Steps
    RecipesCookitAPI recipesCookitAPI;
    @Given("post unlike Recipes with valid path id {int}")
    public void postUnlikeRecipesWithValidPathId(int id) {
        recipesCookitAPI.setPostUnlike(id);
    }

    @When("Send request post unlike with valid path")
    public void sendRequestPostUnlikeWithValidPath() {
        SerenityRest.when().post(RecipesCookitAPI.POST_UNLIKE);
    }

    @And("Validate pos unlike recipes  json schema")
    public void validatePosUnlikeRecipesJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/PostUnlikeValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate pos had been unlike recipes json schema")
    public void validatePosHadBeenUnlikeRecipesJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/PostUnlikeInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
