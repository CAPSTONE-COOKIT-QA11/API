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

public class PostLike {
    @Steps
    RecipesCookitAPI recipesCookitAPI;
    @Given("Post Like with valid path id {int}")
    public void postLikeWithValidPath(int recipes_id) {
        recipesCookitAPI.setPostLikeValid(recipes_id);
    }

    @When("Send request Post Like with valid path")
    public void sendRequestPostLikeWithValidPath() {
        SerenityRest.when().post(RecipesCookitAPI.POST_LIKE_VALID);
    }

    @And("Validate Post like valid path json schema")
    public void validatePostLikeValidPathJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/PostLikeValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

   @Given("Post Like with invalid path recipes {int}")
   public void postLikeWithValidPathRecipes(int recipes_id) {
      recipesCookitAPI.setPostLikeValid(recipes_id);
   }

    @When("Send request Post Like with invalid param")
    public void sendRequestPostLikeWithInvalidParam() {
        SerenityRest.when().post(RecipesCookitAPI.POST_LIKE_VALID);
    }

    @And("Validate Post like invalid path json schema")
    public void validatePostLikeInvalidPathJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/PostLikeValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
