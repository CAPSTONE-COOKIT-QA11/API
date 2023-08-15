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

public class DeleteRecipesIngredient {
    @Steps
    IngredientsAPI ingredientsAPI;

    @Given("Delete recipes ingredient with valid {} and {}")
    public void deleteRecipesIngredientWithValidAnd(int recipe_id, int ingredient_id) {
        ingredientsAPI.deleteRecipesIngredient(recipe_id, ingredient_id);
    }

    @When("Send request recipes ingredient with valid recipe_id")
    public void sendRequestRecipesIngredientWithValidRecipe_id() {
        SerenityRest.when()
                .delete(IngredientsAPI.DELETE_RECIPES_INGREDIENT);
    }

    @And("Validate json schema delete recipe ingredient")
    public void validateJsonSchemaDeleteRecipeIngredient() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Ingredients/DeleteRecipeIngredientValid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Delete recipes ingredient with invalid {string} and {string}")
    public void deleteRecipesIngredientWithInvalidAnd(String recipe_id, String ingredient_id) {
        ingredientsAPI.deleteRecipesIngredientInvalidRecipeId(recipe_id, ingredient_id);
    }

    @When("Send request recipes ingredient with invalid recipe_id")
    public void sendRequestRecipesIngredientWithInvalidRecipe_id() {
        SerenityRest.when()
                .delete(IngredientsAPI.DELETE_RECIPES_INGREDIENT);
    }
}
