Feature: Delete Ingredient Detail
#Positive
  Scenario Outline: Delete Ingredient Detail with Valid id
    Given Delete ingredient detail with valid <recipe_id> and <ingredient_detail_id>
    When Send request ingredient detail with valid recipe id and ingredient detail id
    Then Status code should be 200 OK
    And Validate delete ingredient detail JSON Schema
    Examples:
      | recipe_id | ingredient_detail_id |
      | 240       | 211                  |

#Negative
  Scenario Outline: Delete Ingredient Detail with invalid id
    Given Delete ingredient detail with invalid "<recipe_id>" and "<ingredient_detail_id>"
    When Send request ingredient detail with invalid recipe id and ingredient detail id
    Then Status code should be 400 Bad Request
    Examples:
      | recipe_id | ingredient_detail_id |
      | Asd123    | 211                  |
      | 240       | KL:123               |
      | ASd1234   | lkjdas2              |