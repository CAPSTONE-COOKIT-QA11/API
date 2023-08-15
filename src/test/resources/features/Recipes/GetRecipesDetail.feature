@Test
Feature: Testing API GET Recipes Detail valid path
  Scenario: GET recipes detail with valid path
    Given Get recipes detail with valid path id 1
    When Send request get recipes detail with valid path
    Then Status code should be 200 OK
    And Validate get recipes detail json schema

  Scenario: GET recipes detail with invalid param
    Given Get recipes detail with invalid param id "a"
    When Send request get recipes detail with invalid para
    Then Status code should be 400 Bad Request
    And Validate get recipes detail invalid param json schema