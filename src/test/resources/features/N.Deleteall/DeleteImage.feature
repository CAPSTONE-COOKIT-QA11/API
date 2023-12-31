
Feature: Testing API Delete Image
  Scenario: Delete image with valid id
    Given Delete image with valid id recipe 312
    When Send Delete image
    Then Status code should be 200 OK
    And Validate json schema Delete image valid

  Scenario: Delete image with invalid id
    Given Delete image with invalid id recipe 1
    When Send Delete image
    Then Status code should be 400 Bad Request
    And Validate json schema Delete image invalid

  Scenario: Delete image with valid id and invalid image id
    Given Delete image with valid recipe id 311 and valid image id 235
    When Send Delete image two param
    Then Status code should be 200 OK
    And Validate json schema Delete image invalid param id

  Scenario: Delete image with valid id and invalid image id
    Given Delete image with valid recipe id 311 and invalid image id 1
    When Send Delete image two param
    Then Status code should be 400 Bad Request
    And Validate json schema Delete image invalid param id