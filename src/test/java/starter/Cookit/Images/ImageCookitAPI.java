package starter.Cookit.Images;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.remote.server.handler.UploadFile;
import starter.Utils.Constants;

import java.io.File;

public class ImageCookitAPI {

    public static String POST_IMAGE_VALID_ID = Constants.BASE_URL+"/recipes/{recipe_id}/images";
    public static String PUT_IMAGE_VALID_ID = Constants.BASE_URL +"/recipes/{recipe_id}/images/{image_id}";
    public static String DELETE_IMAGE_VALID = Constants.BASE_URL +"/recipes/{recipe_id}/images";
    public static String DELETE_IMAGE_TWO_PARAM = Constants.BASE_URL +"/recipes/{recipe_id}/images/{image_id}";


    @Step("Post image valid id")
    public void setPostImageValidId(int recipe_id){
        File image = new File(Constants.ASSETS_DIR +"/indomiekuahx.jpg");
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .multiPart("image", image);
    }
    @Step("Post image without file")
    public void setPostImageWithoutFile(int recipe_id){
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id);
    }
    @Step("Post image invalid id")
    public void setPostImageInvalidId(int recipe_id){
        File image = new File(Constants.ASSETS_DIR +"/indomiekuahx.jpg");
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .multiPart("image", image);
    }
    @Step("Put images with valid param")
    public void setPutImageValidId(int recipe_id, int image_id){
        File image = new File(Constants.ASSETS_DIR +"/indomiekuahx.jpg");
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("image_id", image_id)
                .multiPart("image",image);
    }
    @Step("Put image without file with valid param")
    public void setPutImageWithoutFile(int recipe_id,int image_id){
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("image_id", image_id);
    }
    @Step("Delete image with param recipe id")
    public void setDeleteImageValid(int recipe_id){
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id);
    }
    @Step("Delete image with two param")
    public void setDeleteImageTwoParam(int recipe_id, int image_id){
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("image_id", image_id);
    }
}
