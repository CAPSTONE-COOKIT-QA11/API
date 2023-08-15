package starter.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Carts.CartsAPI;
import starter.Utils.Constants;

import java.io.File;

public class DeleteUserCarts {
    @Steps
    CartsAPI cartsAPI;
    @Given("Delete user cart with valid {}")
    public void deleteUserCartWithValid(int cart_id) {
        cartsAPI.deleteUserCarts(cart_id);
    }

    @When("Send request delete user cart with valid cart_id")
    public void sendRequestDeleteUserCartWithValidCart_id() {
        SerenityRest.when()
                .delete(CartsAPI.DELETE_USER_CARTS);
    }

    @And("Validate delete user cart json schema")
    public void validateDeleteUserCartWithJsonSchema() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Carts/DeleteUserCarts.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Given("Delete user cart with invalid {string}")
    public void deleteUserCartWithInvalid(String cart_id) {
        cartsAPI.deleteUserCartsInvalidId(cart_id);
    }

    @When("Send request delete user cart with invalid cart_id")
    public void sendRequestDeleteUserCartWithInvalidCart_id() {
        SerenityRest.when()
                .delete(CartsAPI.DELETE_USER_CARTS);
    }

    @Given("Delete user cart with exceed {}")
    public void deleteUserCartWithExceed(int cart_id) {
        cartsAPI.deleteUserCarts(cart_id);
    }

    @When("Send request delete user cart with exceed cart_id")
    public void sendRequestDeleteUserCartWithExceedCart_id() {
        SerenityRest.when()
                .delete(CartsAPI.DELETE_USER_CARTS);
    }
}
