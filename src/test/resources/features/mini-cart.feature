Feature: Mini Cart


  Scenario: view products in mini-cart

    Given I open the homepage
    And I search products by "Vase"
    And I store the product name of the 1st product with Add to Cart button
    And I click on the first to cart button
#    When I expend the mini-cart
#    Then the previously stored product name is displayed in mini-cart