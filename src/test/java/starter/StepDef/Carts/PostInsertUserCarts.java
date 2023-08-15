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

public class PostInsertUserCarts {
    @Steps
    CartsAPI cartsAPI;
    @Given("Post insert new user cart with valid json")
    public void postInsertNewUserCartWithValidJson() {
        File json = new File(Constants.JSON_REQ_BODY + "/Carts/PostUserCartValidBody.json");
        cartsAPI.insertUserCarts(json);
    }

    @When("Send request insert new user cart with valid json")
    public void sendRequestInsertNewUserCartWithValidJson() {
        SerenityRest.when()
                .post(CartsAPI.POST_USER_CARTS);
    }

    @And("Validate insert new user cart json schema")
    public void validateInsertNewUserCartJsonSchema() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Carts/PostInsertUserCarts.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post insert new user cart with empty json")
    public void postInsertNewUserCartWithEmptyJson() {
        File json = new File(Constants.JSON_REQ_BODY + "/Carts/PostUserCartEmptyBody.json");
        cartsAPI.insertUserCarts(json);
    }

    @When("Send request insert new user cart with empty json")
    public void sendRequestInsertNewUserCartWithEmptyJson() {
        SerenityRest.when()
                .post(CartsAPI.POST_USER_CARTS);
    }
}
