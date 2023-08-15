package starter.Cookit.Users;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Users {
    public static String idForGetUserById;
    public static String USER= Constants.BASE_URL+"/users";
    public static String SEARCH= Constants.BASE_URL+"/users/search";
    public  static String PASSWORD = Constants.BASE_URL+"/users/password";


    @Step("Get user by id positive")
    public void getUserByIdPositive(String id) {
        Users.idForGetUserById = id;
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("get User")
    public void getUser( File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN1)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("PUT Password")
    public void putPassword( File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("PUT Users")
    public void setPutUsers( File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post upgrade verified user positive")
    public void postUpgradeVerifiedUserPositive() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
    }
