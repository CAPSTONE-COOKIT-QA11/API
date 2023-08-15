package starter.Cookit.Transactions_Details;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class TransactionsDetailsAPI {
    public static String GET_TRANSACTIONS_DETAILS = Constants.BASE_URL + "/users/transactions/transaction_detail/{transaction_detail_id}";
    @Step("Get User Transactions Details")
    public void getTransactionsDetails(int transaction_detail_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("transaction_detail_id", transaction_detail_id);
    }

    @Step("Get User Transactions Details Invalid Id")
    public void getTransactionsDetailsInvalidId(String transaction_detail_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("transaction_detail_id", transaction_detail_id);
    }
}
