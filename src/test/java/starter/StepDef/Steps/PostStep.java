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

public class PostStep {
    @Steps
    StepsCookitAPI stepsCookitAPI;
    @Given("Post step with valid data steps id {int}")
    public void postStepWithValidDataStepsId(int recipe_id) {
        File jsonRequest = new File(Constants.JSON_REQ_BODY+"/Steps/StepsPostUSer.json");
        stepsCookitAPI.setPostSteps(recipe_id,jsonRequest);
    }

    @When("Send request post steps valid id")
    public void sendRequestPostStepsValidId() {
        SerenityRest.when().post(StepsCookitAPI.POST_STEPS);
    }
    @And("Validate json schema post step valid")
    public void validateJsonSchemaPostStepValid() {
        File JsonSchema = new File(Constants.JSON_SCHEMA+"/Steps/PostStepsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

    @Given("Post step with Invalid data id steps {int}")
    public void postStepWithInvalidDataIdSteps(int recipe_id) {
        File jsonRequest = new File(Constants.JSON_REQ_BODY+"/Steps/StepsPostUserInvalid.json");
        stepsCookitAPI.setPostStepsInvalid(recipe_id,jsonRequest);
    }

    @When("Send request post steps invalid")
    public void sendRequestPostStepsInvalid() {
        SerenityRest.when().post(StepsCookitAPI.POST_STEPS);
    }

    @And("Validate json schema post step invalid")
    public void validateJsonSchemaPostStepInvalid() {
        File JsonSchema = new File(Constants.JSON_SCHEMA+"/Steps/PostStepsInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }
}
