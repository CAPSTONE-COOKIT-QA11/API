Feature: PUT Users

  @Cook
  Scenario: PUT Users with valid parameter
    Given PUT Users with valid parameter
    When Send request PUT
    Then API response should return 200 OK
    And Validate Message PUT Users JSONSchema

  @Cook
  Scenario: PUT Users with blank parameter
    Given PUT Users with blank parameter
    When Send request PUT
    Then API response should return 200 OK
    And Validate JSON Schema

  @Cook
  Scenario: Get search users with valid parameter username
    Given "udin" as valid username path for get user by username with valid username path
    When Send GET request Search
    Then API response should return 200 OK
    And Validate response body JSON Schema
