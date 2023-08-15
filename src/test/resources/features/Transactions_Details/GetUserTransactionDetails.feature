Feature: Get User Transaction Detail
#Positive
  Scenario Outline: Get User Transaction Detail With Valid Id
    Given Get user transaction detail with valid <transaction_detail_id>
    When Send request get user transaction detail with valid transaction_detail_id
    Then Status code should be 200 OK
    Examples:
      | transaction_detail_id |
      | 154                   |

#Negative
  Scenario Outline: Get User Transaction Detail With Invalid Id
    Given Get user transaction detail with invalid "<transaction_detail_id>"
    When Send request get user transaction detail with invalid transaction_detail_id
    Then Status code should be 400 Bad Request
    Examples:
      | transaction_detail_id |
      | Asd123                |
      | %$#Hu                 |

#Negative
  Scenario Outline: Get User Transaction Detail With Exceed Id
    Given Get user transaction detail with exceed <transaction_detail_id>
    When Send request get user transaction detail with exceed transaction_detail_id
    Then Status code should be 404 Not Found
    Examples:
      | transaction_detail_id |
      | 250                   |