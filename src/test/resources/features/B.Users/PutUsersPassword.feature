Feature: PUT Users Password

  @Cook @PositifCase
  Scenario: PUT users with valid parameter
    Given put password users with valid parameter
    When Send request PUT
    Then API response should return 400 Bad Request
    And Validate json schema
