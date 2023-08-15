package starter.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Recipes.RecipesCookitAPI;
import starter.Utils.Constants;

import java.io.File;

public class GetTimeline {

    @Steps
    RecipesCookitAPI recipesCookitAPI;

   @Given("Get Timeline with valid path")
    public void getTimelineWithValidPath() {
       recipesCookitAPI.setGetTimelineValidPath();
    }
    @When("Send request get timeline with valid path")
    public void sendRequestGetTimelineWithValidPath() {
        SerenityRest.when().get(RecipesCookitAPI.GET_TIMELINE_VALID_PATH);
    }

    @And("Validate get timeline json schema")
    public void validateGetTimelineJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/GetTimeLineValidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get Timeline with paramater id {int}")
    public void getTimelineWithParamaterId(int recipe_id) {
        recipesCookitAPI.setGetTimelineWithParam(recipe_id);
    }

    @When("Send request get timeline with parameter")
    public void sendRequestGetTimelineWithParameter() {
        SerenityRest.when().get(RecipesCookitAPI.GET_TIMELINE_WITH_PARAM);
    }

    @And("Validate get timeline invalid json schema")
    public void validateGetTimelineInvalidJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/Recipes/GetTimeLineInvalidSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
}
