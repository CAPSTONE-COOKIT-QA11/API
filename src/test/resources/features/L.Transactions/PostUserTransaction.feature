Feature: Insert New User Transaction
#Positive
  Scenario: Insert New User Transaction With Valid json
    Given Post insert new user transaction with valid json
    When Send request insert new user transaction with valid json
    Then Status code should be 201 Created
    And Validate insert new user transaction json schema

#Negative
  Scenario: Insert New User Transaction With Empty json
    Given Post insert new user transaction with empty json
    When Send request insert new user transaction with empty json
    Then Status code should be 400 Bad Request