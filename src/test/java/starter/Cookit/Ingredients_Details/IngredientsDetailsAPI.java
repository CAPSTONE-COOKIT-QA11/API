package starter.Cookit.Ingredients_Details;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class IngredientsDetailsAPI {
    public static String POST_INGREDIENTS_DETAILS = Constants.BASE_URL + "/recipes/{recipe_id}/ingredients/{ingredient_id}/ingredientDetails";

    @Step("Post New Ingredients Details")
    public void postIngredientsDetails(int recipe_id, int ingredient_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post New Ingredients Details Invalid Id")
    public void postIngredientsDetailsInvalidId(String recipe_id, String ingredient_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String PUT_INGREDIENTS_DETAILS = Constants.BASE_URL + "/recipes/{recipe_id}/ingredients/ingredientDetails/{ingredient_detail_id}";

    @Step("Put Ingredient Detail")
    public void putIngredientsDetails(int recipe_id, int ingredient_detail_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_detail_id", ingredient_detail_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Ingredient Detail Invalid Id")
    public void putIngredientsDetailsInvalidId(String recipe_id, String ingredient_detail_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_detail_id", ingredient_detail_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String DELETE_INGREDIENTS_DETAILS = Constants.BASE_URL + "/recipes/{recipe_id}/ingredients/ingredientDetails/{ingredient_detail_id}";
    @Step("Delete Ingredient Detail")
    public void deleteIngredientsDetails(int recipe_id, int ingredient_detail_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_detail_id", ingredient_detail_id);
    }

    @Step("Delete Ingredient Detail Invalid Id")
    public void deleteIngredientsDetailsInvalidId(String recipe_id, String ingredient_detail_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_detail_id", ingredient_detail_id);
    }


}
