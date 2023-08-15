package starter.Cookit.Admin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Admin {

    public static String LISTVERIFY= Constants.BASE_URL + "/users/listverify";
    public static String LIST_VERIFY= Constants.BASE_URL + "/users/approval/5";
    public static String LIST_VERIFY_1= Constants.BASE_URL + "/users/approval/12!";

    @Step("put users approval")
    public void setPut( File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN1)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
