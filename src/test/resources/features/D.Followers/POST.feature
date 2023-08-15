Feature: FOLLOWERS

  @Cook @PositifCase
  Scenario Outline: Post follow user with valid id
    Given Post follow user with valid "<id>"
    When Send request POST
    Then Status code should 201 Created
    And API Should response POST JSON Schema
    Examples:
      | id |
      | 2  |


  @Cook @NegativeCase
  Scenario Outline: Post follow user with invalid id
    Given Post follow user with invalid "<id>"
    When Send request POST
    Then Status code should be 404 Not Found
    And API Should response POST JSON Schema
    Examples:
      | id   |
      | @@@! |