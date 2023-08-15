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

public class PutRecipesIngredient {
    @Steps
    IngredientsAPI ingredientsAPI;
    @Given("Put recipes ingredient with valid {} {} and json")
    public void putRecipesIngredientWithValidAndJson(int recipe_id, int ingredient_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients/PutIngredientValidBody.json");
        ingredientsAPI.putRecipesIngredient(recipe_id, ingredient_id, json);
    }

    @When("Send request ingredient with valid recipe_id ingredient_id and json")
    public void sendRequestIngredientWithValidRecipe_idIngredient_idAndJson() {
        SerenityRest.when()
                .put(IngredientsAPI.PUT_RECIPES_INGREDIENT);
    }

    @And("Validate json schema update recipes ingredient")
    public void validateJsonSchemaUpdateRecipesIngredient() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Ingredients/DeleteRecipeValid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Put recipes ingredient with valid {} {} and empty json")
    public void putRecipesIngredientWithValidAndEmptyJson(int recipe_id, int ingredient_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients/PutIngredientEmptyBody.json");
        ingredientsAPI.putRecipesIngredient(recipe_id, ingredient_id, json);
    }

    @When("Send request ingredient with valid recipe_id, ingredient_id and empty json")
    public void sendRequestIngredientWithValidRecipe_idIngredient_idAndEmptyJson() {
        SerenityRest.when()
                .put(IngredientsAPI.PUT_RECIPES_INGREDIENT);
    }

    @Given("Put recipes ingredient with invalid {string} {string} and valid json")
    public void putRecipesIngredientWithInvalidAndValidJson(String recipe_id, String ingredient_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients/PutIngredientValidBody.json");
        ingredientsAPI.putRecipesIngredientInvalidId(recipe_id, ingredient_id, json);
    }

    @When("Send request ingredient with invalid recipe_id, valid ingredient_id and valid json")
    public void sendRequestIngredientWithInvalidRecipe_idValidIngredient_idAndValidJson() {
        SerenityRest.when()
                .put(IngredientsAPI.PUT_RECIPES_INGREDIENT);
    }
}
