@Test
Feature: Testing API POST Recipes Users Recipes
  Scenario: POST Recipes with valid path
    Given post Recipes with valid path
    When Send request post with valid path
    Then Status code should be 201 Created
    And Validate pos recipes json schema