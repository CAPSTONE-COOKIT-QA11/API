@Test
Feature: Testing API GET Timeline
  Scenario: GET Timeline with valid path
    Given Get Timeline with valid path
    When Send request get timeline with valid path
    Then Status code should be 200 OK
    And Validate get timeline json schema

  Scenario: GET Timeline with valid path
    Given Get Timeline with paramater id 5
    When Send request get timeline with parameter
    Then Status code should be 404 Not Found
    And Validate get timeline invalid json schema