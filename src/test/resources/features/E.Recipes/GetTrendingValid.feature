@Test
Feature: Testing API GET Trending
  Scenario: GET Trending with valid path
    Given Get Trending with valid path
    When Send request get trending with valid path
    Then Status code should be 200 OK
    And Validate get trending json schema

  Scenario: GET Trending with valid path
    Given Get Trending with param 9
    When Send request get trending with param
    Then Status code should be 404 Not Found
    And Validate get trending with param json schema