Feature: Get Users

  @Cook
  Scenario: Get Users Login
    Given Get Users Login
    When Send request GET
    Then API response should return 200 OK
    And Validate Message JSONSchemaa
