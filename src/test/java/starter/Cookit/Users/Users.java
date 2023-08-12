package starter.Cookit.Users;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class Users {
    public static String idForGetUserById;
    public static String USERS= Constants.BASE_URL+"/users";

    @Step("Get Users")
    public void getUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get user by id positive")
    public void getUserByIdPositive(String id) {
        Users.idForGetUserById = id;
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}
