Feature: Delete User Cart
#Positive
  Scenario Outline: Delete User Cart With Valid cart_id
    Given Delete user cart with valid <cart_id>
    When Send request delete user cart with valid cart_id
    Then Status code should be 200 OK
    And Validate delete user cart json schema
    Examples:
      | cart_id |
      | 65      |

#Negative
  Scenario Outline: Delete User Cart With Invalid cart_id
    Given Delete user cart with invalid "<cart_id>"
    When Send request delete user cart with invalid cart_id
    Then Status code should be 400 Bad Request
    Examples:
      | cart_id |
      | Asd123  |
      | lkj0%   |

#Negative
  Scenario Outline: Delete User Cart With Exceed cart_id
    Given Delete user cart with exceed <cart_id>
    When Send request delete user cart with exceed cart_id
    Then Status code should be 404 Not Found
    Examples:
      | cart_id |
      | 250     |