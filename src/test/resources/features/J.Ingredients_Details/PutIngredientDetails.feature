Feature: Update Ingredient Details
#Positive
  Scenario Outline: Update Ingredient with Valid id and json
  Given Put update ingredient with valid <recipe_id>, <ingredient_detail_id>, and json
  When Send request ingredient with valid recipe_id, ingredient_detail_id, and json
  Then Status code should be 200 OK
    Examples:
      | recipe_id | ingredient_detail_id |
      | 317       | 220                  |

#Negative
  Scenario Outline: Update Ingredient with Valid id and empty json
    Given Put update ingredient with valid <recipe_id>, <ingredient_detail_id>, and empty json
    When Send request ingredient with valid recipe_id, ingredient_detail_id, and empty json
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id | ingredient_detail_id |
      | 317       | 220                   |

#Negative
  Scenario Outline: Update Ingredient with Invalid id and Valid json
    Given Put update ingredient with invalid "<recipe_id>", "<ingredient_detail_id>", and valid json
    When Send request ingredient with invalid recipe_id, ingredient_detail_id, and valid json
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id | ingredient_detail_id |
      | Asd123    | 210                  |
      | 240       | Jkl:12               |
      | asD123    | jkl789               |

#Negative
  Scenario Outline: Update Ingredient with Exceed id and Valid json
    Given Put update ingredient with exceed <recipe_id>, <ingredient_detail_id>, and valid json
    When Send request ingredient with exceed recipe_id, ingredient_detail_id, and valid json
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id | ingredient_detail_id |
      | 500       | 750                  |
      | 1200      | 807                  |