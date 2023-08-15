package starter.Cookit.Followers;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class Follow {
    public static String idUserToFollow;
    public static int idUserToUnollow;

    public static String USER= Constants.BASE_URL+"/users";
    @Step("Post follow user positive")
    public void postFollowUserPositive(String id) {
        Follow.idUserToFollow = id;
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}
