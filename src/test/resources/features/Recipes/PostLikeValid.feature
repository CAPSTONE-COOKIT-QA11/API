@Test
Feature: Testing API Post LIke
  Scenario: POST Like with valid path
    Given Post Like with valid path id 254
    When Send request Post Like with valid path
    Then Status code should be 200 OK
    And Validate Post like valid path json schema

  Scenario: POST Like with valid path
    Given Post Like with valid path recipes 245
    When Send request Post Like with invalid param
    Then Status code should be 400 Bad Request
    And Validate Post like invalid path json schema