
Feature: Testing API GET Recipes
  Scenario: GET recipes with valid path
    Given Get recipes with valid path
    When Send request get recipes with valid path
    Then Status code should be 200 OK
    And Validate get recipes json schema

  Scenario: GET recipes with invalid path
    Given Get recipes with invalid path
    When Send request get recipes with invalid path
    Then Status code should be 404 Not Found
    And Validate get recipes invalid json schema

