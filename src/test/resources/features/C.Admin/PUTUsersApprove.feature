Feature: PUT approve users
  @Cook @PositifCase
  Scenario: Get list verify with valid path
    Given Get list verify users
    When Send get list verify
    Then API response should return 200 OK
    And Validate get list verify with valid path json schema

    @Cook @PositifCase
      Scenario: PUT Users approval with valid parameter
      Given PUT users approval with valid parameter
      When send request PUT
      Then API response should return 200 OK
      And API Should response JSON Schemaa

  @Cook @NegativeCase
  Scenario: PUT Users approval with invalid parameter
    Given PUT users approval with invalid parameter
    When send request PUT users
    Then API response should return 200 OK
    And API Should response JSON Schemaa