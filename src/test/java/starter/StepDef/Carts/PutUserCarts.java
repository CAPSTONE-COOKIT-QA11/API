package starter.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.checkerframework.checker.units.qual.C;
import starter.Cookit.Carts.CartsAPI;
import starter.Utils.Constants;

import java.io.File;

public class PutUserCarts {
    @Steps
    CartsAPI cartsAPI;

    @Given("Put update user cart with valid {} and valid json")
    public void putUpdateUserCartWithValidAndValidJson(int cart_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Carts/PutUserCartValidBody.json");
        cartsAPI.putUserCarts(cart_id, json);
    }

    @When("Send request update user cart with valid cart_id and valid json")
    public void sendRequestUpdateUserCartWithValidCart_idAndValidJson() {
        SerenityRest.when()
                .put(CartsAPI.PUT_USER_CARTS);
    }

    @And("Validate update user cart with valid json schema")
    public void validateUpdateUserCartWithValidJsonSchema() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Carts/PutUpdateUserCarts.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Put update user cart with valid {} and empty json")
    public void putUpdateUserCartWithValidAndEmptyJson(int cart_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Carts/PutUserCartEmptyBody.json");
        cartsAPI.putUserCarts(cart_id, json);
    }

    @When("Send request update user cart with valid cart_id and empty json")
    public void sendRequestUpdateUserCartWithValidCart_idAndEmptyJson() {
        SerenityRest.when()
                .put(CartsAPI.PUT_USER_CARTS);
    }

    @Given("Put update user cart with invalid {string} and valid json")
    public void putUpdateUserCartWithInvalidAndValidJson(String cart_id) {
        File json = new File(Constants.JSON_REQ_BODY + "/Carts/PutUserCartValidBody.json");
        cartsAPI.putUserCartsInvalidId(cart_id, json);
    }

    @When("Send request update user cart with invalid cart_id and valid json")
    public void sendRequestUpdateUserCartWithInvalidCart_idAndValidJson() {
        SerenityRest.when()
                .put(CartsAPI.PUT_USER_CARTS);
    }
}
