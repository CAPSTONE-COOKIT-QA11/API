package starter.Cookit.Steps;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class StepsCookitAPI {
    public static String POST_STEPS = Constants.BASE_URL + "/recipes/{recipe_id}/steps";
    public static String PUT_STEPS = Constants.BASE_URL + "/recipes/{recipe_id}/steps/{step_id}";
    public static String POST_STEPS_INVALID = Constants.BASE_URL + "/recipes/{recipe_id}/steps";
    public static String DELETE_STEP_TWO_PARAM = Constants.BASE_URL + "/recipes/{recipe_id}/steps/{step_id}";
    public static String DELETE_STEP_VALID_PARAM = Constants.BASE_URL + "/recipes/{recipe_id}/steps";

    @Step("Post Steps")
    public void setPostSteps (int recipe_id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put Steps")
    public void setPutSteps (int recipe_id, int step_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("step_id", step_id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post Steps invalid param")
    public void setPostStepsInvalid(int recipe_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete Steps with two param")
    public void setDeleteStepTwoParam(int recipe_id, int step_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("step_id", step_id);
    }
    @Step("Delete step with valid param")
    public void setDeleteStepValidParam(int recipe_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id);
    }

}
