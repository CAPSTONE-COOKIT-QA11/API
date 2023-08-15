@Test
Feature: Testing API POST Recipes Users Recipes
  Scenario: POST like recipes with valid path
    Given post Recipes with valid path
    When Send request post with valid path
    Then Status code should be 201 Created
    And Validate pos recipes json schema

  Scenario: POST Recipes with invalid path
    Given post Recipes with invalid path
    When Send request post with invalid path
    Then Status code should be 404 Not Found
    And Validate post recipes invalid path json schema