Feature: Delete Recipes Ingredient
  #Positive
  Scenario Outline: Delete Recipes Ingredient with Valid id
    Given Delete recipes ingredient with valid <recipe_id> and <ingredient_id>
    When Send request recipes ingredient with valid recipe_id
    Then Status code should be 200 OK
    And Validate json schema delete recipe ingredient
    Examples:
      | recipe_id | ingredient_id |
      | 316       | 137           |

  #Negative
  Scenario Outline: Delete Recipes Ingredient with invalid id
    Given Delete recipes ingredient with invalid "<recipe_id>" and "<ingredient_id>"
    When Send request recipes ingredient with invalid recipe_id
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id | ingredient_id |
      | Asd123    | 121           |
      | 236       | A()1          |
      | jkl890    | Asd123        |