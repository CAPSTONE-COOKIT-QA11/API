@Test
Feature: Testing API PUT Recipes Users Recipes
  Scenario: PUT Recipes Update users  with valid id
    Given Put Recipes Update users valid json with id 199
    When Send request put update recipes
    Then Status code should be 200 OK
    And Validate put update recipes json schema