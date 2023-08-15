@Test
Feature: Testing API POST Comments
  Scenario: POST Comments with valid path
    Given POST Comments with valid id 1
    When Send request post Comments with valid path
    Then Status code should be 201 Created
    And Validate post Comments Valid json schema

  Scenario: POST Comments with invalid param
    Given POST Comments with invalid param id "a1"
    When Send request post Comments with invalid param
    Then Status code should be 400 Bad Request
    And Validate post Comments inValid json schema