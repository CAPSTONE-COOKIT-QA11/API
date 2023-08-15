Feature: Update Recipes Ingredient
#Positive
  Scenario Outline: Update Recipes Ingredient with valid id and JSON
  Given Put recipes ingredient with valid <recipe_id> <ingredient_id> and json
  When Send request ingredient with valid recipe_id ingredient_id and json
  Then Status code should be 200 OK
  And Validate json schema update recipes ingredient
    Examples:
      | recipe_id | ingredient_id |
      | 236       | 121           |

#Negative
  Scenario Outline: Update Recipes Ingredient with valid id and empty JSON
  Given Put recipes ingredient with valid <recipe_id> <ingredient_id> and empty json
  When Send request ingredient with valid recipe_id, ingredient_id and empty json
  Then Status code should be 400 Bad Request
    Examples:
      | recipe_id | ingredient_id |
      | 250       | 126           |

#Negative
  Scenario Outline: Update Recipes Ingredient with invalid id
    Given Put recipes ingredient with invalid "<recipe_id>" "<ingredient_id>" and valid json
    When Send request ingredient with invalid recipe_id, valid ingredient_id and valid json
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id | ingredient_id |
      | Asd123    | 121           |
      | 236       | Asd33@        |
      | bALONku>  | peCel9        |
