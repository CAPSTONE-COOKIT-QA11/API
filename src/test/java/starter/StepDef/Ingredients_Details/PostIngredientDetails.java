package starter.StepDef.Ingredients_Details;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Ingredients_Details.IngredientsDetailsAPI;
import starter.Utils.Constants;

import java.io.File;

public class PostIngredientDetails {
    @Steps
    IngredientsDetailsAPI ingredientsDetailsAPI;

    @Given("Post insert ingredient detail with valid {}, {}, and json")
    public void postInsertIngredientDetailWithValidRecipe_idIngredient_idAndJson(int recipe_id, int ingredient_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients_Details/PostIngredientDetailValidBody.json");
        ingredientsDetailsAPI.postIngredientsDetails(recipe_id, ingredient_id, json);
    }

    @When("Send request post insert ingredient detail with valid recipe_id, ingredient_id, and json")
    public void sendRequestPostInsertIngredientDetailWithValidRecipe_idIngredient_idAndJson() {
        SerenityRest.when()
                .post(IngredientsDetailsAPI.POST_INGREDIENTS_DETAILS);
    }

    @And("Validate insert ingredient details JSON Schema")
    public void validateInsertIngredientDetailsJSONSchema() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Ingredients_Details/PostIngredientDetailValid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post insert ingredient detail with valid {}, {}, and empty json")
    public void postInsertIngredientDetailWithValidRecipe_idIngredient_idAndEmptyJson(int recipe_id, int ingredient_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients_Details/PostIngredientDetailEmptyBody.json");
        ingredientsDetailsAPI.postIngredientsDetails(recipe_id, ingredient_id, json);
    }

    @When("Send request post insert ingredient detail with valid recipe_id, ingredient_id, and empty json")
    public void sendRequestPostInsertIngredientDetailWithValidRecipe_idIngredient_idAndEmptyJson() {
        SerenityRest.when()
                .post(IngredientsDetailsAPI.POST_INGREDIENTS_DETAILS);
    }

    @Given("Post insert ingredient detail with invalid {string}, {string}, and valid json")
    public void postInsertIngredientDetailWithInvalidRecipe_idIngredient_idAndValidJson(String recipe_id, String ingredient_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients_Details/PostIngredientDetailValidBody.json");
        ingredientsDetailsAPI.postIngredientsDetailsInvalidId(recipe_id, ingredient_id, json);
    }

    @When("Send request post insert ingredient detail with invalid recipe_id, ingredient_id, and valid json")
    public void sendRequestPostInsertIngredientDetailWithInvalidRecipe_idIngredient_idAndValidJson() {
        SerenityRest.when()
                .post(IngredientsDetailsAPI.POST_INGREDIENTS_DETAILS);
    }

    @Given("Post insert ingredient detail with exceed {}, {}, and valid json")
    public void postInsertIngredientDetailWithExceedRecipe_idIngredient_idAndValidJson(int recipe_id, int ingredient_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients_Details/PostIngredientDetailValidBody.json");
        ingredientsDetailsAPI.postIngredientsDetails(recipe_id, ingredient_id, json);
    }

    @When("Send request post insert ingredient detail with exceed recipe_id, ingredient_id, and valid json")
    public void sendRequestPostInsertIngredientDetailWithExceedRecipe_idIngredient_idAndValidJson() {
        SerenityRest.when()
                .post(IngredientsDetailsAPI.POST_INGREDIENTS_DETAILS);
    }
}
