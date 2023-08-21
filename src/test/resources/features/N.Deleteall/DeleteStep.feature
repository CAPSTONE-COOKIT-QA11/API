Feature: Delete Step

  Scenario: Delete Steps with valid recipe id
    Given Delete step with valid recipe id 315
    When Send request delete steps valid id
    Then Status code should be 200 OK
    And Validate json schema delete valid param

  Scenario: Delete Steps with invalid recipe id
    Given Delete step with invalid recipe id 199
    When Send request delete steps invalid id
    Then Status code should be 400 Bad Request
    And Validate json schema delete invalid param

  Scenario: Delete Steps with valid recipe id and step id
    Given delete step with valid param and body recipes 314 steps 245
    When Send request delete steps valid recipe id and step id
    Then Status code should be 200 OK
    And Validate json schema delete valid two param

  Scenario: Delete Steps with invalid recipe id and step id
    Given delete step with invalid param and body recipes 203 steps 214
    When Send request delete steps invalid recipe id and step id
    Then Status code should be 400 Bad Request
    And Validate json schema delete invalid step id