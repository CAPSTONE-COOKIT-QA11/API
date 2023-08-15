package starter.StepDef.Transactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Transactions.TransactionsApi;

public class PutUserStatusTransaction {
    @Steps
    TransactionsApi transactionsApi;
    @Given("Put update user transaction with valid {}")
    public void putUpdateUserTransactionWithValid(int transaction_id) {
        transactionsApi.putUserStatusTransactions(transaction_id);
    }

    @When("Send request update user transaction with valid transaction_id")
    public void sendRequestUpdateUserTransactionWithValidTransaction_id() {
        SerenityRest.when()
                .put(TransactionsApi.PUT_USER_STATUS_TRANSACTIONS);
    }

    @Given("Put update user transaction with invalid {string}")
    public void putUpdateUserTransactionWithInvalid(String transaction_id) {
        transactionsApi.putUserStatusTransactionsInValidId(transaction_id);
    }

    @When("Send request update user transaction with invalid transaction_id")
    public void sendRequestUpdateUserTransactionWithInvalidTransaction_id() {
        SerenityRest.when()
                .put(TransactionsApi.PUT_USER_STATUS_TRANSACTIONS);
    }

    @Given("Put update user transaction with exceed {}")
    public void putUpdateUserTransactionWithExceed(int transaction_id) {
        transactionsApi.putUserStatusTransactions(transaction_id);
    }

    @When("Send request update user transaction with exceed transaction_id")
    public void sendRequestUpdateUserTransactionWithExceedTransaction_id() {
        SerenityRest.when()
                .put(TransactionsApi.PUT_USER_STATUS_TRANSACTIONS);
    }


}
