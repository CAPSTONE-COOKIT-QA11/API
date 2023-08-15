Feature: GET Users Search

@Cook @PositifCase
  Scenario: Get search users with valid parameter username
    Given "udin" as valid username path for get user by username with valid username path
    When Send GET request Search
    Then API response should return 200 OK
    And Validate response body JSON Schema

 @Cook @NegativeCase
  Scenario: Get search users with blank parameter
   Given GET Search Users with blank parameter
   When Send GET Search request
   Then API response should return 404 Not Found
   And Validate JSON Schema