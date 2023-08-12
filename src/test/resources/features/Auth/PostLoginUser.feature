Feature: Post Login User

  @Cook
  Scenario: Post login student with valid and complete JSON body
    Given Post login with valid and complete JSON body
    When Send POST request for login
    Then API response should return 200 OK
    And Validate Message JSON Schema