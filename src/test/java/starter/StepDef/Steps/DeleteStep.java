package starter.StepDef.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Steps.StepsCookitAPI;
import starter.Utils.Constants;

import java.io.File;

public class DeleteStep {
    @Steps
    StepsCookitAPI stepsCookitAPI;
    @Given("Delete step with valid recipe id {int}")
    public void deleteStepWithValidRecipeId(int recipe_id) {
        stepsCookitAPI.setDeleteStepValidParam(recipe_id);
    }

    @When("Send request delete steps valid id")
    public void sendRequestDeleteStepsValidId() {
        SerenityRest.when().delete(StepsCookitAPI.DELETE_STEP_VALID_PARAM);
    }

    @And("Validate json schema delete valid param")
    public void validateJsonSchemaDeleteStepValidParam() {
        File JsonSchema = new File(Constants.JSON_SCHEMA+"/Steps/DeleteStepsValidRecipeIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

    @Given("Delete step with invalid recipe id {int}")
    public void deleteStepWithInvalidRecipeId(int recipe_id) {
        stepsCookitAPI.setDeleteStepValidParam(recipe_id);
    }

    @When("Send request delete steps invalid id")
    public void sendRequestDeleteStepsInvalidId() {
        SerenityRest.when().delete(StepsCookitAPI.DELETE_STEP_VALID_PARAM);
    }

    @And("Validate json schema delete invalid param")
    public void validateJsonSchemaDeleteInvalidParam() {
        File JsonSchema = new File(Constants.JSON_SCHEMA+"/Steps/DeleteStepsValidRecipeIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

    @Given("delete step with valid param and body recipes {int} steps {int}")
    public void deleteStepWithValidParamAndBodyRecipesSteps(int recipe_id, int step_id) {
        stepsCookitAPI.setDeleteStepTwoParam(recipe_id, step_id);
    }

    @When("Send request delete steps valid recipe id and step id")
    public void sendRequestDeleteStepsValidRecipeIdAndStepId() {
        SerenityRest.when().delete(StepsCookitAPI.DELETE_STEP_TWO_PARAM);
    }

    @And("Validate json schema delete valid two param")
    public void validateJsonSchemaDeleteValidTwoParam() {
        File JsonSchema = new File(Constants.JSON_SCHEMA+"/Steps/DeleteStepsValidRecipeIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

    @Given("delete step with invalid param and body recipes {int} steps {int}")
    public void deleteStepWithInvalidParamAndBodyRecipesSteps(int recipe_id, int step_id) {
        stepsCookitAPI.setDeleteStepTwoParam(recipe_id, step_id);
    }

    @When("Send request delete steps invalid recipe id and step id")
    public void sendRequestDeleteStepsInvalidRecipeIdAndStepId() {
        SerenityRest.when().delete(StepsCookitAPI.DELETE_STEP_TWO_PARAM);
    }

    @And("Validate json schema delete invalid step id")
    public void validateJsonSchemaDeleteInvalidStepId() {
        File JsonSchema = new File(Constants.JSON_SCHEMA+"/Steps/DeleteStepsValidRecipeIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }
}
