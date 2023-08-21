Feature: Insert New User Carts
#Positive
  Scenario: Insert New User Cart With Valid JSON
    Given Post insert new user cart with valid json
    When Send request insert new user cart with valid json
    Then Status code should be 201 Created
    And Validate insert new user cart json schema

#Negative
  Scenario: Insert New User With Empty JSON
    Given Post insert new user cart with empty json
    When Send request insert new user cart with empty json
    Then Status code should be 400 Bad Request