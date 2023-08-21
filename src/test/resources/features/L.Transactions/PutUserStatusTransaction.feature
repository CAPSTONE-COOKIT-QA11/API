Feature: Update User Status Transaction
#Positive
  Scenario Outline: Update User Transaction With Valid Transaction id
    Given Put update user transaction with valid <transaction_id>
    When Send request update user transaction with valid transaction_id
    Then Status code should be 200 OK
    Examples:
      | transaction_id |
      | 164            |

#Negative
  Scenario Outline: Update User Transaction With Invalid Transaction id
    Given Put update user transaction with invalid "<transaction_id>"
    When Send request update user transaction with invalid transaction_id
    Then Status code should be 400 Bad Request
    Examples:
      | transaction_id |
      | Asd123         |
      | sf3!!23        |

#Negative
  Scenario Outline: Update User Transaction With Exceed Transaction id
    Given Put update user transaction with exceed <transaction_id>
    When Send request update user transaction with exceed transaction_id
    Then Status code should be 404 Not Found
    Examples:
      | transaction_id |
      | 350            |