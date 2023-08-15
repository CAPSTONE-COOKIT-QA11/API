package starter.Cookit.Recipes;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class RecipesCookitAPI {
    public static String GET_RECIPES = Constants.BASE_URL + "/recipes";
    public static String POST_RECIPES_VALID_PATH = Constants.BASE_URL + "/recipes";
    public static String PUT_RECIPE_VALID_ID = Constants.BASE_URL+"/recipes/{id}";

    @Step("Get Recipes")
    public void setGetRecipes(){
        SerenityRest.given().headers("Authorization","Bearer"+Constants.BEARER_TOKEN);
    }

    @Step("Post recipes")
    public void setPostRecipes(File json){
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put recipes valid id")
    public void setPutRecipeValidId(int id, File json){;
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
