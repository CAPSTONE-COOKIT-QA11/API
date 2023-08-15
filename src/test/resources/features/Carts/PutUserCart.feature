Feature: Update User Cart
#Positive
  Scenario Outline: Update User Cart With Valid id and json
    Given Put update user cart with valid <cart_id> and valid json
    When Send request update user cart with valid cart_id and valid json
    Then Status code should be 200 OK
    And Validate update user cart with valid json schema
    Examples:
      | cart_id |
      | 67      |

#Negative
  Scenario Outline: Update User Cart With Valid id and Empty json
    Given Put update user cart with valid <cart_id> and empty json
    When Send request update user cart with valid cart_id and empty json
    Then Status code should be 400 Bad Request
    Examples:
      | cart_id |
      | 65      |

#Negative
  Scenario Outline: Update User Cart With Invalid id and valid json
    Given Put update user cart with invalid "<cart_id>" and valid json
    When Send request update user cart with invalid cart_id and valid json
    Then Status code should be 400 Bad Request
    Examples:
      | cart_id |
      | Asd123  |
      | <>1#as  |