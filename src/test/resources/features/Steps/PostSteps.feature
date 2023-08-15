Feature: Post Steps
  Scenario: insert new steps with valid id Steps
  Given Post step with valid data steps id 200
  When Send request post steps valid id
  Then Status code should be 201 Created
  And Validate json schema post step valid

  Scenario: insert new steps with invalid id Steps
    Given Post step with Invalid data id steps 199
    When Send request post steps invalid
    Then Status code should be 400 Bad Request
    And Validate json schema post step invalid
