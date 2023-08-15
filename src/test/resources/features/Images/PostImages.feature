@Test

Feature: Testing API Post Image
  Scenario: Post image with valid id
    Given Post image with valid id recipe 189
    When Send post image
    Then Status code should be 201 Created
    And Validate json schema post image valid

  Scenario: Post image without file with valid id
    Given Send post image without file with valid id recipe 189
    When Send post image without file
    Then Status code should be 520 an unknown error

  Scenario: Post image with invalid id
    Given Post image with invalid id recipe 1
    When Send post image
    Then Status code should be 400 Bad Request
    And Validate json schema post image invalid
