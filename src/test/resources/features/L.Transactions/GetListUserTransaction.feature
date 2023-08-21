Feature: Get List User Transaction
#Positive
  Scenario: Get List User Transaction with Valid Path
    Given Get list user transaction with valid path
    When Send request get list user transation with valid path
    Then Status code should be 200 OK
    And Validate get list user transation json schema

#Negative
  Scenario: Get List User Transaction with Invalid Path
    Given Get list user transaction with invalid path
    When Send request get list user transation with invalid path
    Then Status code should be 400 Bad Request