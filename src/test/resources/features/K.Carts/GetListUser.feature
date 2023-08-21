Feature: Get List User Carts
#Positive
  Scenario: Get List User Cart with Valid Path
    Given Get list user cart with valid path
    When Send request get list user cart with valid path
    Then Status code should be 200 OK
    And Validate get list user json schema

#Negative
  Scenario: Get List User Cart with Invalid Path
    Given Get list user cart with invalid path
    When Send request get list user cart with invalid path
    Then Status code should be 400 Bad Request