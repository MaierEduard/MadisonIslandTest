Feature: Add products to cart

  Scenario: Check price after adding product to cart against the one from product page

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the blue color and size M
    When I add product to cart
    Then the "product price" is the same as in "shopping cart" page


  Scenario: Same product is added twice with different quantities

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the black color and size M
#    Flaviu
    And I change the quantity in 3
    And I add product to cart
    And I go back to the product page
    And I change the quantity in 2
    When I add product to cart
    Then the total quantity is listed


  Scenario: Add a product to cart without color

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the size M
    And I add product to cart
    Then the product is not added to cart


  Scenario: Add product to cart without size

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the color black
    When I add product to cart
    Then the product is not added to cart


  Scenario: Remove product from cart (quantity = 1)

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the blue color and size M
    And I add product to cart
    When I remove the first product
    Then the product is removed from cart


  Scenario: Remove product from cart (quantity = 2)

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the black color and size M
    And I add products to cart
    And I click on logo
    And I select Pants & Denim from Women category
    And I select Tribeca Skinny Jean
    And I select the color black
    And I select size 28
    And I add products to cart
    When I remove the second product
    Then the second product is removed from cart


  Scenario: Sub total for products

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the black color and size M
#    Flaviu
    And I change the quantity in 3
    When I add products to cart
    Then total price equals sum of individual prices


  Scenario: Check if i change quantity with one product in shopping cart

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the black color and size M
    And I add product to cart
    When I change quantity in "2"
    And I click the update button
    Then I expect the quantity of product to change


# Flaviu;   is doua teste?
  Scenario: Check if I change quantities with 2 products in shopping to cart
    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the black color and size M
    And I add product to cart
    And I select Pants & Denim from Women category
    And I select Tribeca Skinny Jean
    And I select the color black
    And I select size 28
    And I add product to cart
    And I change quantity for first product in "2" and for second product in "3"
    When I click UPDATE SHOPPING CART
    Then I expect the both quantity of products to change


  Scenario: Check if DISCOUNT CODES work correctly with wrong code

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the black color and size M
    And I add product to cart
    And I select country "România"
    And I select state "Cluj"
    And I populate City field with "Cluj-Napoca"
    And I populate ZIP field with "356656"
    And I populate Discount Code field with "598558"
    When I click the apply button to verify the discount code
    Then I expect a confirmation message that the code is not valid


  Scenario Outline: Check if DISCOUNT CODES work correctly with multiple wrong code

    Given I open the homepage
    And I open the product Chelsea Tee page
    And I select the black color and size M
    And I add product to cart
    And I select country "<Country>"
    And I select state "<State>"
    And I populate City field with "<City>"
    And I populate ZIP field with "<Zip Code>"
    And I populate Discount Code field with "<Discount Code>"
    When I click the apply button to verify the discount code
    Then I expect a confirmation message that the code is not valid

    Examples:
      | Country | State    | City          | Zip Code | Discount Code               |
      | România | Cluj     | Cluj-Napoca   | 398954   | I don't have any code       |
      | România | Botoşani | Botoşani      | 259877   | I don't have any code 789## |
      | România | Bihor    | Oradea        | 2559877  | 789## I don't have any code |
      | România | Cluj     | Campia-Turzii | 2559877  | 789##79595565               |














