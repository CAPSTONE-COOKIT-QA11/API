package starter.Cookit.Transactions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class TransactionsApi {
    public static String LIST_USER_TRANSACTIONS = Constants.BASE_URL + "/users/transactions";

    @Step("List User Transaction")
    public void listUserTransactions(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    public static String LIST_USER_TRANSACTIONS_INVALID_PATH = Constants.BASE_URL + "/users/transactions123";

    @Step("List User Transaction")
    public void listUserTransactionsInvalidPath(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    public static String POST_USER_TRANSACTIONS = Constants.BASE_URL + "/users/transactions";
    @Step("Insert New User Transaction")
    public void postUserTransactions(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }


    public static String PUT_USER_STATUS_TRANSACTIONS = Constants.BASE_URL + "/users/transactions/{transaction_id}/status";
    @Step("Update User Status Transaction")
    public void putUserStatusTransactions(int transaction_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("transaction_id", transaction_id);
    }

    @Step("Update User Status Transaction Invalid Id")
    public void putUserStatusTransactionsInValidId(String transaction_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("transaction_id", transaction_id);
    }


}
