package starter.Cookit.Ingredients;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class IngredientsAPI {

    public static String POST_INGREDIENTS = Constants.BASE_URL + "/recipes/{recipe_id}/ingredients";
    @Step("Post New Recipes Ingredient")
    public void postIngredients(int recipe_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post New Recipes Ingredient with Invalid recipe_id")
    public void postIngredientsInvalidRecipeId(String recipe_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String DELETE_RECIPES = Constants.BASE_URL + "/recipes/{recipe_id}/ingredients";
    public static String DELETE_RECIPES_EMPTY_ID = Constants.BASE_URL + "/recipes//ingredients";
    @Step("Delete Recipes")
    public void deleteRecipes(int recipe_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id);
    }

    @Step("Delete Recipes with invalid recipe_id")
    public void deleteRecipesInvalidRecipeId(String recipe_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id);
    }

    @Step("Delete Recipes with Empty recipe_id")
    public void deleteRecipesEmptyRecipeId(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    public static String PUT_RECIPES_INGREDIENT = Constants.BASE_URL + "/recipes/{recipe_id}/ingredients/{ingredient_id}";
    @Step("Put Recipes Ingredient")
    public void putRecipesIngredient(int recipe_id, int ingredient_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Recipes Ingredient")
    public void putRecipesIngredientInvalidId(String recipe_id, String ingredient_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String DELETE_RECIPES_INGREDIENT = Constants.BASE_URL + "/recipes/{recipe_id}/ingredients/{ingredient_id}";
    @Step("Delete Recipes Ingredient")
    public void deleteRecipesIngredient(int recipe_id, int ingredient_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id);
    }

    @Step("Delete Recipes Ingredient with invalid id")
    public void deleteRecipesIngredientInvalidRecipeId(String recipe_id, String ingredient_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id);
    }
}
