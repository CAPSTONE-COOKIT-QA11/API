Feature: DELETE

  @Cook @PositifCase
  Scenario Outline: DELETE follow user with invalid id
    Given Delete follow user with valid "<id>"
    When Send request POST
    Then Status code should be 404 Not Found
    And API Should response POST JSON Schema
    Examples:
      | id |
      | 1  |