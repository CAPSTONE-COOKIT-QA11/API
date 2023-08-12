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

public class PutRecipes {

    @Steps
    RecipesCookitAPI recipesCookitAPI;
    @Given("Put Recipes Update users valid json with id {int}")
    public void putRecipesUpdateUsersValidJsonWithId(int id) {
        File JsonRequest = new File(Constants.JSON_REQ_BODY+"/Recipes/RecipesPutUser.json");
        recipesCookitAPI.setPutRecipeValidId(id,JsonRequest);
    }

    @When("Send request put update recipes")
    public void sendRequestPutUpdateRecipes() {
        SerenityRest.when().put(RecipesCookitAPI.PUT_RECIPE_VALID_ID);
    }

    @And("Validate put update recipes json schema")
    public void validatePutUpdateRecipesJsonSchema() {
        File JsonSchema = new File(Constants.JSON_SCHEMA+"/Recipes/PutRecipesSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }
}
