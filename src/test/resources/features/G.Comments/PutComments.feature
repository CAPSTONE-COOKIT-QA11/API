
@Test
Feature: Put comment
  Scenario: Put comment with valid id
    Given Put Comments with id 312 comment id 158
    When Send request put comments
    Then Status code should be 200 OK
    And Validate put Comments Valid json schema

  Scenario: Put comment with invalid id
    Given Put Comments with id 1 comment id 76
    When Send request put comments
    Then Status code should be 400 Bad Request
    And Validate put Comments Invalid json schema