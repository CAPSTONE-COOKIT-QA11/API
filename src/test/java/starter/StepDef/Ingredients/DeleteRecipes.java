package starter.StepDef.Ingredients;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Ingredients.IngredientsAPI;
import starter.Utils.Constants;

import java.io.File;

public class DeleteRecipes {
    @Steps
    IngredientsAPI ingredientsAPI;

    @Given("Delete recipes with valid {}")
    public void deleteRecipesWithValid(int recipe_id) {
        ingredientsAPI.deleteRecipes(recipe_id);
    }

    @When("Send request recipes with valid recipe_id")
    public void sendRequestRecipesWithValidRecipe_id() {
        SerenityRest.when()
                .delete(IngredientsAPI.DELETE_RECIPES);
    }

    @Given("Delete recipes with invalid {}")
    public void deleteRecipesWithInvalid(String recipe_id) {
        ingredientsAPI.deleteRecipesInvalidRecipeId(recipe_id);
    }

    @When("Send request recipes with invalid recipe_id")
    public void sendRequestRecipesWithInvalidRecipe_id() {
        SerenityRest.when()
                .delete(IngredientsAPI.DELETE_RECIPES);
    }

    @Given("Delete recipes with empty recipe_id")
    public void deleteRecipesWithEmptyRecipe_id() {
        ingredientsAPI.deleteRecipesEmptyRecipeId();
    }

    @When("Send request recipes with empty recipe_id")
    public void sendRequestRecipesWithEmptyRecipe_id() {
        SerenityRest.when()
                .delete(IngredientsAPI.DELETE_RECIPES_EMPTY_ID);
    }

    @And("Validate json schema delete recipe")
    public void validateJsoSchemaDeleteRecipe() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Ingredients/DeleteRecipeValid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
