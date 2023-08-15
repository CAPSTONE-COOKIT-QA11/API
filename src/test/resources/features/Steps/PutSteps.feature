
Feature: Testing API Post Steps
  Scenario: Put steps with valid param and body
    Given Put step with valid param and body recipes 203 steps 226
    When Send request put step
    Then Status code should be 200 OK
    And Validate json schema put step

  Scenario: Put steps with invalid param and valid body
    Given Put step with invalid param and body recipes 203 steps 100
    When Send request put steps
    Then Status code should be 400 Bad Request
    And Validate json schema put steps