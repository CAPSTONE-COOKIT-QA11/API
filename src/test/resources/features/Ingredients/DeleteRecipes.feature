Feature: Delete Recipes
  #Positive
 Scenario Outline: Delete Recipes with Valid recipe id
   Given Delete recipes with valid <recipe_id>
   When Send request recipes with valid recipe_id
   Then Status code should be 200 OK
   And Validate json schema delete recipe
   Examples:
     | recipe_id |
     | 204       |

  #Negative
  Scenario Outline: Delete Recipes with Invalid recipe id
    Given Delete recipes with invalid <recipe_id>
    When Send request recipes with invalid recipe_id
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id |
      | asd123    |
      | jLk@1     |

  #Negative
  Scenario: Delete Recipes with Empty recipe id
    Given Delete recipes with empty recipe_id
    When Send request recipes with empty recipe_id
    Then Status code should be 400 Bad Request
