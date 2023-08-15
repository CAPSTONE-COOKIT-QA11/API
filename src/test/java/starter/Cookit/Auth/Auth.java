package starter.Cookit.Auth;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;


public class Auth {

    public static String POST_CREATE_USER= Constants.BASE_URL+"/register";
    public static final String POST_LOGIN = Constants.BASE_URL + "/login";

    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login")
    public void postLogin (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Login with valid data")
    public void setPostLoginUtama(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
