package starter.Cookit.Carts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class CartsAPI {
    public static String LIST_USER_CARTS = Constants.BASE_URL + "/users/carts";

    @Step("List User Carts")
    public void listUserCarts(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    public static String LIST_USER_CARTS_INVALID_PATH = Constants.BASE_URL + "/users/cartsasd123";
    public void listUserCartsInvalidPath(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    public static String POST_USER_CARTS = Constants.BASE_URL + "/users/carts";
    @Step("Insert New User Carts")
    public void insertUserCarts(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String PUT_USER_CARTS = Constants.BASE_URL + "/users/carts/{cart_id}";
    @Step("Update User Carts")
    public void putUserCarts(int cart_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("cart_id", cart_id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update User Carts Invalid Id")
    public void putUserCartsInvalidId(String cart_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("cart_id", cart_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String DELETE_USER_CARTS = Constants.BASE_URL + "/users/carts/{cart_id}";
    @Step("Delete User Cart")
    public void deleteUserCarts(int cart_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("cart_id", cart_id);
    }

    @Step("Delete User Cart Invalid Id")
    public void deleteUserCartsInvalidId(String cart_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("cart_id", cart_id);
    }


}
