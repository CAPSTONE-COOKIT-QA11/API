
Feature:
  Scenario: insert new steps with valid id Steps
  Given Post step with valid data id steps 199
  When Send request post steps
  Then Status code should be 201 Created
  And Validate json schema post step