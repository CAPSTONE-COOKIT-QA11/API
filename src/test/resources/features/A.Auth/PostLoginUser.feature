Feature: Post Login User

@Cook
Scenario: Post login student with valid and complete JSON body
  Given Post login with valid and complete JSON body
  When Send POST request for login
  Then API response should return 200 OK
  And Validate Message JSON Schema

  @Cook
  Scenario: Post login with valid parameter username and blank parameter password
    Given Post login with valid parameter username and blank parameter password
    When Send POST request for login
    Then API response should return 400 Bad Request
    And Validate JSON Schema

  @Cook
  Scenario: Post login with blank parameter username and valid parameter password
    Given Post login with blank parameter username and valid parameter password
    When Send POST request for login
    Then API response should return 400 Bad Request
    And Validate JSON Schema