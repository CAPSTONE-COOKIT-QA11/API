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

public class GetListUserTransaction {
    @Steps
    TransactionsApi transactionsApi;
    @Given("Get list user transaction with valid path")
    public void getListUserTransactionWithValidPath() {
        transactionsApi.listUserTransactions();
    }

    @When("Send request get list user transation with valid path")
    public void sendRequestGetListUserTransationWithValidPath() {
        SerenityRest.when()
                .get(TransactionsApi.LIST_USER_TRANSACTIONS);
    }

    @And("Validate get list user transation json schema")
    public void validateGetListUserTransationJsonSchema() {
        File jsonSchema = new File(Constants.JSON_SCHEMA+"/Transactions/GetListUserTransaction.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list user transaction with invalid path")
    public void getListUserTransactionWithInvalidPath() {
        transactionsApi.listUserTransactionsInvalidPath();
    }

    @When("Send request get list user transation with invalid path")
    public void sendRequestGetListUserTransationWithInvalidPath() {
        SerenityRest.when()
                .get(TransactionsApi.LIST_USER_TRANSACTIONS_INVALID_PATH);
    }
}
