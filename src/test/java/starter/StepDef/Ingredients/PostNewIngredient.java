package starter.StepDef.Ingredients;

import io.cucumber.java.bs.I;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Ingredients.IngredientsAPI;
import starter.Utils.Constants;

import java.io.File;

public class PostNewIngredient {

    @Steps
    IngredientsAPI ingredientsAPI;

    @Given("Post insert new recipes ingredient with valid json and {}")
    public void postInsertNewRecipesIngredientWithValidJsonAndId(int recipe_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients/PostIngredientValidBody.json");
        ingredientsAPI.postIngredients(recipe_id, json);
    }

    @When("Send insert new recipes ingredient with valid json")
    public void sendInsertNewRecipesIngredientWithValidJson() {
        SerenityRest.when()
                .post(IngredientsAPI.POST_INGREDIENTS);
    }

    @And("Validate json schema insert new recipes")
    public void validateJsonSchemaInsertNewRecipes() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Ingredients/PostIngredientValid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post insert new recipes ingredient with invalid json and valid {}")
    public void postInsertNewRecipesIngredientWithInvalidJsonAnd(int recipe_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients/PostIngredientInvalidBody.json");
        ingredientsAPI.postIngredients(recipe_id, json);
    }

    @When("Send insert new recipes ingredient with invalid json")
    public void sendInsertNewRecipesIngredientWithInvalidJson() {
        SerenityRest.when()
                .post(IngredientsAPI.POST_INGREDIENTS);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int code) {
        SerenityRest.then()
                .statusCode(code);
    }

    @Given("Post insert new recipes ingredient with empty json and valid {}")
    public void postInsertNewRecipesIngredientWithEmptyJsonAndValid(int recipe_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients/PostIngredientEmptyBody.json");
        ingredientsAPI.postIngredients(recipe_id, json);
    }

    @When("Send insert new recipes ingredient with empty")
    public void sendInsertNewRecipesIngredientWithEmpty() {
        SerenityRest.when()
                .post(IngredientsAPI.POST_INGREDIENTS);
    }

    @Given("Post insert new recipes ingredient with invalid {string}")
    public void postInsertNewRecipesIngredientWithInvalid(String recipe_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients/PostIngredientValidBody.json");
        ingredientsAPI.postIngredientsInvalidRecipeId(recipe_id, json);
    }

    @When("Send insert new recipes ingredient with invalid recipe_id")
    public void sendInsertNewRecipesIngredientWithInvalidRecipe_id() {
        SerenityRest.when()
                .post(IngredientsAPI.POST_INGREDIENTS);
    }

    @Given("Post insert new recipes ingredient with exceed {}")
    public void postInsertNewRecipesIngredientWithExceed(int recipe_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Ingredients/PostIngredientValidBody.json");
        ingredientsAPI.postIngredients(recipe_id, json);
    }

    @When("Send insert new recipes ingredient with exceed recipe_id")
    public void sendInsertNewRecipesIngredientWithExceedRecipe_id() {
        SerenityRest.when()
                .post(IngredientsAPI.POST_INGREDIENTS);
    }
}
