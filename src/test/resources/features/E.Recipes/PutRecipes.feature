@Test
Feature: Testing API PUT Recipes Users Recipes
  Scenario: PUT Recipes Update users  with valid id
    Given Put Recipes Update users valid json with id 310
    When Send request put update recipes
    Then Status code should be 200 OK
    And Validate put update recipes json schema

  Scenario: PUT Recipes Update users  with valid id invalid request body
    Given Put Recipes Update users invalid json with valid id 310
    When Send request put update recipes
    Then Status code should be 400 Bad Request
    And Validate put update recipes invalid json schema

