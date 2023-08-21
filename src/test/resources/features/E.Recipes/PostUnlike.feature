Feature: Testing API POST Recipes Users Recipes
  Scenario: POST unlike Recipes with valid path
    Given post unlike Recipes with valid path id 310
    When Send request post unlike with valid path
    Then Status code should be 200 OK
    And Validate pos unlike recipes  json schema

  Scenario: POST unlike Recipes with param had been unlike
    Given post unlike Recipes with invalid path id 8
    When Send request post unlike with valid path
    Then Status code should be 400 Bad Request
    And Validate pos had been unlike recipes json schema