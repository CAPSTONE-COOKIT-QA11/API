Feature: Delete Recipes

  Scenario: Delete recipes with valid path
    Given Delete recipes with valid param id 249
    When Send request Delete recipes with valid path
    Then Status code should be 200 OK
    And Validate delete recipes valid json schema

  Scenario: Delete recipes with recipe id had been delete
    Given Delete recipes with invalid param id 249
    When Send request Delete recipes with invalid path
    Then Status code should be 400 Bad Request
    And Validate delete recipes invalid json schema