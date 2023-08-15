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

public class GetListUserCarts {
    @Steps
    CartsAPI cartsAPI;
    @Given("Get list user cart with valid path")
    public void getListUserCartWithValidPath() {
        cartsAPI.listUserCarts();
    }

    @When("Send request get list user cart with valid path")
    public void sendRequestGetListUserCartWithValidPath() {
        SerenityRest.when()
                .get(CartsAPI.LIST_USER_CARTS);
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Carts/ListUserCart.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list user cart with invalid path")
    public void getListUserCartWithInvalidPath() {
        cartsAPI.listUserCartsInvalidPath();
    }

    @When("Send request get list user cart with invalid path")
    public void sendRequestGetListUserCartWithInvalidPath() {
        SerenityRest.when()
                .get(CartsAPI.LIST_USER_CARTS_INVALID_PATH);
    }
}
