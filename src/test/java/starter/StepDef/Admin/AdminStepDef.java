package starter.StepDef.Admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Admin.Admin;
import starter.Cookit.Users.Users;
import starter.Utils.Constants;

import java.io.File;


public class AdminStepDef {
    @Steps
    Admin admin;

    @Given("Get list verify users")
    public void getListVerifyUsers() {
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.BEARER_TOKEN1);
    }
    @When("Send get list verify")
    public void sendGetListVerify() {
        SerenityRest.when().get(Admin.LISTVERIFY);
    }

    @And("Validate get list verify with valid path json schema")
    public void validateGetListVerifyWithValidPathJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/Admin/GetListVerify.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }

    @Given("PUT users approval with valid parameter")
    public void putUsers() {
        File json = new File(Constants.JSON_REQ_BODY + "/Admin/PUTid.json");
        admin.setPut(json);
    }
    @When("send request PUT")
    public void sendRequestPUT() {
        SerenityRest.when().put(Admin.LIST_VERIFY);
    }
    @And("API Should response JSON Schemaa")
    public void apiShouldResponseJSONSchemaa() {
        File json = new File(Constants.JSON_SCHEMA + "/Admin/putidschema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("PUT users approval with invalid parameter")
    public void putUsersApprovalWithInvalidParameter() {
        File json = new File(Constants.JSON_REQ_BODY + "/Admin/PUTid.json");
        admin.setPut(json);
    }

    @When("send request PUT users")
    public void sendRequestPUTUsers() {
        SerenityRest.when().put(Admin.LIST_VERIFY_1);
    }
}
