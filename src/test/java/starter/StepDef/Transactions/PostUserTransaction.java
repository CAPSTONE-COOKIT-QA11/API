package starter.StepDef.Transactions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Transactions.TransactionsApi;
import starter.Utils.Constants;

import java.io.File;

public class PostUserTransaction {
    @Steps
    TransactionsApi transactionsApi;
    @Given("Post insert new user transaction with valid json")
    public void postInsertNewUserTransactionWithValidJson() {
        File json = new File(Constants.JSON_REQ_BODY + "/Transactions/PostUserTransactionValidBody.json");
        transactionsApi.postUserTransactions(json);
    }

    @When("Send request insert new user transaction with valid json")
    public void sendRequestInsertNewUserTransactionWithValidJson() {
        SerenityRest.when()
                .post(TransactionsApi.POST_USER_TRANSACTIONS);
    }

    @And("Validate insert new user transaction json schema")
    public void validateInsertNewUserTransactionJsonSchema() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Transactions/PostUserTransactionValid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post insert new user transaction with empty json")
    public void postInsertNewUserTransactionWithInvalidJson() {
        File json = new File(Constants.JSON_REQ_BODY + "/Transactions/PostUserTransactionEmptyBody.json");
        transactionsApi.postUserTransactions(json);
    }

    @When("Send request insert new user transaction with empty json")
    public void sendRequestInsertNewUserTransactionWithInvalidJson() {
        SerenityRest.when()
                .post(TransactionsApi.POST_USER_TRANSACTIONS);
    }
}
