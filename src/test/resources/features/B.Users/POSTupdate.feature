Feature:  POST user update

  @Cook @PositifCase
  Scenario: Post upgrade verified user with valid path
    Given Valid path for post upgrade verified user with valid path
    When Send POST request for post upgrade verified user with valid path
    Then API response for post upgrade verified user with valid path should return 201 Created status code
    And Validate response body JSON Schema for post upgrade verified user with valid path
