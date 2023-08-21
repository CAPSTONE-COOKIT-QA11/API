package starter.Cookit.Recipes;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class RecipesCookitAPI {
    public static String GET_RECIPES = Constants.BASE_URL + "/recipes";
    public static String POST_RECIPES_VALID_PATH = Constants.BASE_URL + "/recipes";
    public static String PUT_RECIPE_VALID_ID = Constants.BASE_URL + "/recipes/{id}";
    public static String GET_TIMELINE_VALID_PATH = Constants.BASE_URL +"/users/recipes/timeline";
    public static String GET_TRENDING_VALID_PATH = Constants.BASE_URL +"/recipes/trending";
    public static String GET_RECIPES_DETAIL_VALID = Constants.BASE_URL +"/recipes/{id}/detail";
    public static String POST_LIKE_VALID = Constants.BASE_URL + "/recipes/{recipes_id}/like";
    public static String GET_RECIPES_INVALID = Constants.BASE_URL+"/recipe";
    public static String GET_TRENDING_WITH_PARAM = Constants.BASE_URL +"/recipes/trending/{id}";
    public static String GET_RECIPES_DETAIL_INVALID = Constants.BASE_URL +"/recipes/{id}/detail";
    public static String DELETE_RECIPES_VALID_PARAM = Constants.BASE_URL+"/recipes/{recipe_id}";
    public static String POST_UNLIKE = Constants.BASE_URL+ "/recipes/{id}/unlike";
    public static String GET_TIMELINE_WITH_PARAM = Constants.BASE_URL + "/users/recipes/timeline/{recipe_id}";
    public static String DELETE_RECIPES_INVALID_PARAM = Constants.BASE_URL+"/recipes/{recipe_id}";


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
    @Step("Post Like Valid")
    public void setPostLikeValid(int recipes_id){
        SerenityRest.given().headers("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipes_id);
    }
    @Step("Post unlike recipes")
    public void setPostUnlike(int id){
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN)
                .pathParam("id", id);
    }
    @Step("Delete recipes with param had been delete")
    public void setDeleteRecipesInvalidParam(int recipe_id){
        SerenityRest.given().headers("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id);
    }
    @Step("Delete Recipes valid param")
    public void setDeleteRecipesValidParam(int id){
        SerenityRest.given().headers("Authorization","Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", id);
    }
    @Step("Get recipes detail valid")
    public void setGetRecipesDetailValid(int id) {
        SerenityRest.given().headers("Authorization","Bearer"+Constants.BEARER_TOKEN)
                .pathParam("id", id);
    }
    @Step("Get detail recipes invalid param")
    public void setGetRecipesDetailInvalid(String id){
        SerenityRest.given().headers("Authorization","Bearer"+Constants.BEARER_TOKEN)
                .pathParam("id", id);
    }
    @Step("Get timeline valid path")
    public void setGetTimelineValidPath(){
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN);
    }
    @Step("Get timeline with param")
    public void setGetTimelineWithParam(int recipe_id){
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id);

    }
    @Step("Get Tending valid path")
    public void setGetTrendingValidPath(){
        SerenityRest.given().headers("Authorization","Bearer"+Constants.BEARER_TOKEN);
    }
    @Step("Get trending with param")
    public void setGetTrendingWithParam(int id){
        SerenityRest.given().headers("Authorization","Bearer"+ Constants.BEARER_TOKEN)
                .pathParam("id", id);
    }
}
