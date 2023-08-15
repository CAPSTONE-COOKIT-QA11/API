package starter.StepDef.Ingredients_Details;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Ingredients_Details.IngredientsDetailsAPI;
import starter.Utils.Constants;

import java.io.File;

public class PutIngredientDetails {
    @Steps
    IngredientsDetailsAPI ingredientsDetailsAPI;
    @Given("Put update ingredient with valid {}, {}, and json")
    public void putUpdateIngredientWithValidAndJson(int recipe_id, int ingredient_detail_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients_Details/PutIngredientDetailValidBody.json");
        ingredientsDetailsAPI.putIngredientsDetails(recipe_id, ingredient_detail_id, json);
    }

    @When("Send request ingredient with valid recipe_id, ingredient_detail_id, and json")
    public void sendRequestIngredientWithValidRecipe_idIngredient_detail_idAndJson() {
        SerenityRest.when()
                .put(IngredientsDetailsAPI.PUT_INGREDIENTS_DETAILS);
    }

    @Given("Put update ingredient with valid {}, {}, and empty json")
    public void putUpdateIngredientWithValidAndEmptyJson(int recipe_id, int ingredient_detail_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients_Details/PutIngredientDetailEmptyBody.json");
        ingredientsDetailsAPI.putIngredientsDetails(recipe_id, ingredient_detail_id, json);
    }

    @When("Send request ingredient with valid recipe_id, ingredient_detail_id, and empty json")
    public void sendRequestIngredientWithValidRecipe_idIngredient_detail_idAndEmptyJson() {
        SerenityRest.when()
                .put(IngredientsDetailsAPI.PUT_INGREDIENTS_DETAILS);
    }

    @Given("Put update ingredient with invalid {string}, {string}, and valid json")
    public void putUpdateIngredientWithInvalidAndValidJson(String recipe_id, String ingredient_detail_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients_Details/PutIngredientDetailValidBody.json");
        ingredientsDetailsAPI.putIngredientsDetailsInvalidId(recipe_id, ingredient_detail_id, json);
    }

    @Given("Put update ingredient with exceed {}, {}, and valid json")
    public void putUpdateIngredientWithExceedAndValidJson(int recipe_id, int ingredient_detail_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients_Details/PutIngredientDetailValidBody.json");
        ingredientsDetailsAPI.putIngredientsDetails(recipe_id, ingredient_detail_id, json);
    }

    @When("Send request ingredient with invalid recipe_id, ingredient_detail_id, and valid json")
    public void sendRequestIngredientWithInvalidRecipe_idIngredient_detail_idAndValidJson() {
        SerenityRest.when()
                .put(IngredientsDetailsAPI.PUT_INGREDIENTS_DETAILS);
    }

    @When("Send request ingredient with exceed recipe_id, ingredient_detail_id, and valid json")
    public void sendRequestIngredientWithExceedRecipe_idIngredient_detail_idAndValidJson() {
        SerenityRest.when()
                .put(IngredientsDetailsAPI.PUT_INGREDIENTS_DETAILS);
    }
}
