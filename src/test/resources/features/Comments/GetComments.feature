@Cook
Feature: Testing API GET Comments
  Scenario: GET Comments with valid path
    Given Get Comments with valid id 132
    When Send request get Comments with valid path
    Then Status code should be 200 OK
    And Validate get Comments Valid json schema

  Scenario: GET Comments with invalid path
    Given Get Comments with invalid param id "a1"
    When Send request get Comments with invalid path
    Then Status code should be 400 Bad Request
    And Validate get Comments inValid json schema