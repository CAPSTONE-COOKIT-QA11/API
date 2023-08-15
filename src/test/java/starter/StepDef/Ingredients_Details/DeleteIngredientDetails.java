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

public class DeleteIngredientDetails {
    @Steps
    IngredientsDetailsAPI ingredientsDetailsAPI;
    @Given("Delete ingredient detail with valid {} and {}")
    public void deleteIngredientDetailWithValidRecipeIdAndIngredientDetailId(int recipe_id, int ingredient_detail_id) {
        ingredientsDetailsAPI.deleteIngredientsDetails(recipe_id, ingredient_detail_id);
    }

    @When("Send request ingredient detail with valid recipe id and ingredient detail id")
    public void sendRequestIngredientDetailWithValidRecipeIdAndIngredientDetailId() {
        SerenityRest.when()
                .delete(IngredientsDetailsAPI.DELETE_INGREDIENTS_DETAILS);
    }

    @And("Validate delete ingredient detail JSON Schema")
    public void validateDeleteIngredientDetailJSONSchema() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Ingredients/DeleteIngredientDetailValid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Delete ingredient detail with invalid {string} and {string}")
    public void deleteIngredientDetailWithInvalidAnd(String recipe_id, String ingredient_detail_id) {
        ingredientsDetailsAPI.deleteIngredientsDetailsInvalidId(recipe_id, ingredient_detail_id);
    }

    @When("Send request ingredient detail with invalid recipe id and ingredient detail id")
    public void sendRequestIngredientDetailWithInvalidRecipeIdAndIngredientDetailId() {
        SerenityRest.when()
                .delete(IngredientsDetailsAPI.DELETE_INGREDIENTS_DETAILS);
    }
}
