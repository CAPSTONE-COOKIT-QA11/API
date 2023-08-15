Feature: PUT Users

  @Cook @Bug
  Scenario: PUT Users with valid parameter
    Given PUT users with valid parameter
    When send PUT request
    Then API response should return 200 OK
    And API Should response PUT JSON Schema


