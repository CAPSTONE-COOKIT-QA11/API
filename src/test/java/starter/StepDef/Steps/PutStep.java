package starter.StepDef.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Recipes.RecipesCookitAPI;
import starter.Cookit.Steps.StepsCookitAPI;
import starter.Utils.Constants;

import java.io.File;

public class PutStep {
    @Steps
    StepsCookitAPI stepsCookitAPI;
    @Given("Put step with valid param and body recipes {int} steps {int}")
    public void putStepWithValidParamAndBodyRecipesSteps(int recipe_id, int step_id) {
        File jsonRequest = new File(Constants.JSON_REQ_BODY+"/Steps/StepsPutUser.json");
        stepsCookitAPI.setPutSteps(recipe_id,step_id,jsonRequest);
    }

    @When("Send request put step")
    public void sendRequestPutStep() {
        SerenityRest.when().put(StepsCookitAPI.PUT_STEPS);
    }

    @And("Validate json schema put step")
    public void validateJsonSchemaPutStep() {
        File JsonSchema = new File(Constants.JSON_SCHEMA+"/Steps/PutStepsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

    @Given("Put step with invalid param and body recipes {int} steps {int}")
    public void putStepWithInvalidParamAndBodyRecipesSteps(int recipe_id, int step_id) {
        File jsonRequest = new File(Constants.JSON_REQ_BODY+"/Steps/StepsPutUser.json");
        stepsCookitAPI.setPutSteps(recipe_id, step_id,jsonRequest);
    }

    @When("Send request put steps")
    public void sendRequestPutSteps() {
        SerenityRest.when().put(StepsCookitAPI.PUT_STEPS);
    }

    @And("Validate json schema put steps")
    public void validateJsonSchemaPutSteps() {
        File JsonSchema = new File(Constants.JSON_SCHEMA+"/Steps/PutStepsInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }
}
