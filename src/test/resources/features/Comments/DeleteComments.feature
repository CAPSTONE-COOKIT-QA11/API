@Cook
Feature: Delete Comments
  Scenario: Delete Comments with valid param
    Given Delete comments with valid param and body recipes 1 comments 134
    When Send request delete comments
    Then Status code should be 200 OK
    And Validate json schema Delete comments valid

  Scenario: Delete Comments with valid param had been delete
    Given Delete comments with valid param and body recipes 1 comments 76
    When Send request delete comments
    Then Status code should be 400 Bad Request
    And Validate json schema Delete comments invalid
