package starter.Cookit.Steps;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class StepsCookitAPI {
    public static String POST_STEPS = Constants.BASE_URL + "/recipes/{id}/steps";

    @Step("Post Steps")
    public void setPostSteps (int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
