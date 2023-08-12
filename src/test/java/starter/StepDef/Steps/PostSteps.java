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

public class PostSteps {

    @Steps
    StepsCookitAPI stepsCookitAPI;

    @Given("Post step with valid data id steps {int}")
    public void postStepWithValidDataIdSteps(int id) {
        File JsonReq = new File(Constants.JSON_REQ_BODY + "/Steps/StepsPostUSer.json");
        stepsCookitAPI.setPostSteps(id, JsonReq);
    }

    @When("Send request post steps")
    public void sendRequestPostSteps() {
        SerenityRest.when().post(StepsCookitAPI.POST_STEPS);
    }

    @And("Validate json schema post step")
    public void validateJsonSchemaPostStep() {
        File json = new File(Constants.JSON_SCHEMA + "/Steps/PostStepsSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
