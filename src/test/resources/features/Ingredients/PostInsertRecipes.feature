Feature: Insert New Recipes Ingredient
 #positive
   Scenario Outline: Insert New Recipes Ingredient with Valid JSON and recipe_id
    Given Post insert new recipes ingredient with valid json and <recipe_id>
    When Send insert new recipes ingredient with valid json
    Then Status code should be 201 Created
    And Validate json schema insert new recipes
     Examples:
       | recipe_id |
       | 259       |
       | 204       |

 #negative
  Scenario Outline: Insert New Recipes Ingredient with invalid JSON and valid recipe_id
    Given Post insert new recipes ingredient with invalid json and valid <recipe_id>
    When Send insert new recipes ingredient with invalid json
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id |
      | 259        |
      | 204       |


 #negative
  Scenario Outline: Insert New Recipes Ingredient with empty JSON and recipe_id
    Given Post insert new recipes ingredient with empty json and valid <recipe_id>
    When Send insert new recipes ingredient with empty
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id |
      | 203       |
      | 204       |

 #negative
  Scenario Outline: Insert New Recipes Ingredient with Invalid recipe_id
    Given Post insert new recipes ingredient with invalid "<recipe_id>"
    When Send insert new recipes ingredient with invalid recipe_id
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id |
      | Asd123    |
      | jlk?@1    |

 #negative
  Scenario Outline: Insert New Recipes Ingredient with exceed recipe_id
    Given Post insert new recipes ingredient with exceed <recipe_id>
    When Send insert new recipes ingredient with exceed recipe_id
    Then Status code should be 404 Not Found
    Examples:
      | recipe_id |
      | 1950      |
      | 9999      |
