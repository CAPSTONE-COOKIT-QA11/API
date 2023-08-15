package starter.StepDef.Transactions_Details;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Transactions_Details.TransactionsDetailsAPI;

public class GetUserTransactionDetails {
    @Steps
    TransactionsDetailsAPI transactionsDetailsAPI;

    @Given("Get user transaction detail with valid {}")
    public void getUserTransactionDetailWithValid(int transaction_detail_id) {
        transactionsDetailsAPI.getTransactionsDetails(transaction_detail_id);
    }

    @When("Send request get user transaction detail with valid transaction_detail_id")
    public void sendRequestGetUserTransactionDetailWithValidTransaction_detail_id() {
        SerenityRest.when()
                .get(TransactionsDetailsAPI.GET_TRANSACTIONS_DETAILS);
    }

    @Given("Get user transaction detail with invalid {string}")
    public void getUserTransactionDetailWithInvalid(String transaction_detail_id) {
        transactionsDetailsAPI.getTransactionsDetailsInvalidId(transaction_detail_id);
    }

    @When("Send request get user transaction detail with invalid transaction_detail_id")
    public void sendRequestGetUserTransactionDetailWithInvalidTransaction_detail_id() {
        SerenityRest.when()
                .get(TransactionsDetailsAPI.GET_TRANSACTIONS_DETAILS);
    }

    @Given("Get user transaction detail with exceed {}")
    public void getUserTransactionDetailWithExceed(int transaction_detail_id) {
        transactionsDetailsAPI.getTransactionsDetails(transaction_detail_id);
    }

    @When("Send request get user transaction detail with exceed transaction_detail_id")
    public void sendRequestGetUserTransactionDetailWithExceedTransaction_detail_id() {
        SerenityRest.when()
                .get(TransactionsDetailsAPI.GET_TRANSACTIONS_DETAILS);
    }
}
