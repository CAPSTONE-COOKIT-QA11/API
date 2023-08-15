Feature: Register new user h
  @Cookit
  Scenario: Post create new register with valid json
    Given Post create register with valid json
    When Send post create
    Then Status code should be 201 Created
    And Validate create new user JSON Schema

  #Scenario: Post register with blank parameter
   # Given Post create register with blank parameter
    #When Send post create
    #Then Status code should be 404 Not Found
    #And Validate create new user invalid JSON Schema