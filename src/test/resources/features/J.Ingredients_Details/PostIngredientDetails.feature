Feature: Insert New Ingredient Details
#Positive
  Scenario Outline: Insert Ingredient Details with Valid id and json
  Given Post insert ingredient detail with valid <recipe_id>, <ingredient_id>, and json
  When Send request post insert ingredient detail with valid recipe_id, ingredient_id, and json
  Then Status code should be 201 Created
  And Validate insert ingredient details JSON Schema
    Examples:
      | recipe_id | ingredient_id |
      | 317       | 140           |

#Negative
  Scenario Outline: Insert Ingredient Details with Valid id and empty json
    Given Post insert ingredient detail with valid <recipe_id>, <ingredient_id>, and empty json
    When Send request post insert ingredient detail with valid recipe_id, ingredient_id, and empty json
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id | ingredient_id |
      | 317       | 140            |

#Negative
  Scenario Outline: Insert Ingredient Details with Invalid id and Valid json
    Given Post insert ingredient detail with invalid "<recipe_id>", "<ingredient_id>", and valid json
    When Send request post insert ingredient detail with invalid recipe_id, ingredient_id, and valid json
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id | ingredient_id |
      | Asd123    | 123           |
      | 240       | Asd123        |
      | P3c3l     | jkl&y6        |

#Negative
  Scenario Outline: Insert Ingredient Details with Exceed id and Valid json
    Given Post insert ingredient detail with exceed <recipe_id>, <ingredient_id>, and valid json
    When Send request post insert ingredient detail with exceed recipe_id, ingredient_id, and valid json
    Then Status code should be 404 Not Found
    Examples:
      | recipe_id | ingredient_id |
      | 1950      | 1000          |
      | 1999      | 950           |