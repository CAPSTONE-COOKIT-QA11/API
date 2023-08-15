
Feature: Put Images

  Scenario: Put image with valid id and image id
    Given Put image with valid id recipe 254 and image 215
    When Send Put image
    Then Status code should be 200 OK
    And Validate json schema post image valid id

  Scenario: Put image with valid id and invalid image id
    Given Put image with valid id recipe 254 and invalid image id 1
    When Send Put image
    Then Status code should be 400 Bad Request
    And Validate json schema post image invalid id

  Scenario: Put image without file with valid id and valid image id
    Given Put image without file with valid recipe id 254 and invalid image id 215
    When Send Put image
    Then Status code should be 400 Bad Request
    And Validate json schema post image invalid param id