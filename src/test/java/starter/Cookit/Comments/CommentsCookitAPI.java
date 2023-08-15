package starter.Cookit.Comments;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class CommentsCookitAPI {
    public static String GET_COMMENTS_VALID = Constants.BASE_URL+"/recipes/{ID}/comments";
    public static String POST_COMMENTS_VALID = Constants.BASE_URL+"/recipes/{id}/comments";
    public static String POST_COMMENTS_INVALID = Constants.BASE_URL+"/recipes/{id}/comments";
    public static String GET_COMMENTS_INVALID = Constants.BASE_URL+"/recipes/{ID}/comments";
    public static String PUT_COMMENTS_VALID = Constants.BASE_URL+ "/recipes/{ID}/comments/{id}";
    public static String DELETE_COMMENTS  = Constants.BASE_URL+ "/recipes/{ID}/comments/{id}";

    @Step("Get Comments Valid")
    public void setGetCommentsValid(int ID){
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN_USERVERIF)
                .pathParam("ID",ID);

    }
    @Step("Post Comments Valid")
    public void setPostCommentsValid(int id, File json) {
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.BEARER_TOKEN_USERVERIF)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post Comments Valid")
    public void setPostCommentsInvalid(String id, File json) {
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.BEARER_TOKEN_USERVERIF)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get Comments Invalid")
    public void setGetCommentsInvalid(String ID){
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN_USERVERIF)
                .pathParam("ID",ID);
    }
    @Step("Put Comments Valid")
    public void setPutCommentsValid(int ID, int id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN_USERVERIF)
                .pathParam("ID",ID)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);;
    }
    @Step("Delete comments valid")
    public void setDeleteComments(int ID, int id){
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN_USERVERIF)
                .pathParam("ID",ID)
                .pathParam("id", id);

    }


    }
