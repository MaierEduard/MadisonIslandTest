Feature: Add products to cart

  Scenario: Check price after adding product to cart against the one from product page

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Blue"
    And I select size "M"
    When I verify price and I add product to cart
    Then the "product price" is the same as in "shopping cart" page


  Scenario: Same product is added twice with different quantities

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I change the quantity in product page in 3
    And I add product to cart
    And I go back to the product page
    And I change the quantity in product page in 2
    When I add product to cart
    Then the total quantity is listed


  Scenario: Add a product to cart without color

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select size "M"
    And I add product to cart
    Then the product is not added to cart


  Scenario: Add product to cart without size

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    When I add product to cart
    Then the product is not added to cart


  Scenario: Remove product from cart (quantity = 1)

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add product to cart
    When I remove the first product
    Then the product is removed from cart


  Scenario: Remove product from cart (quantity = 2)

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add products to cart
    And I click on logo
    And I go to "Women" category and I select "Pants & Denim"
    And I select product "TriBeCa Skinny Jean"
    And I select the color "Black"
    And I select size "28"
    And I add products to cart
    When I remove the second product
    Then the second product is removed from cart


  Scenario: Sub total for products

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I change the quantity in product page in 3
    When I add products to cart
    Then total price equals sum of individual prices


  Scenario: Check if i change quantity with one product in shopping cart

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add product to cart
    When I change quantity in 2
    And I click the update button
    Then I expect the quantity of product to change


  Scenario: Check if I change quantities with 2 products in shopping to cart
    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add product to cart
    And I go to "Women" category and I select "Pants & Denim"
    And I select product "TriBeCa Skinny Jean"
    And I select the color "Black"
    And I select size "28"
    And I add product to cart
    And I change quantity for first product in "2" and for second product in "3"
    When I click UPDATE SHOPPING CART
    Then I expect the both quantity of products to change


  Scenario: Check if DISCOUNT CODES work correctly with wrong code

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add product to cart
    And I select country "România"
    And I select state "Cluj"
    And I populate City field with "Cluj-Napoca"
    And I populate ZIP field with "356656"
    And I populate Discount Code field with "598558"
    When I click the apply button
    Then I expect a confirmation message that the code is not valid


  Scenario Outline: Check if DISCOUNT CODES work correctly with multiple wrong code

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add product to cart
    And I select country "<Country>"
    And I select state "<State>"
    And I populate City field with "<City>"
    And I populate ZIP field with "<Zip Code>"
    And I populate Discount Code field with "<Discount Code>"
    When I click the apply button
    Then I expect a confirmation message that the code is not valid

    Examples:
      | Country | State    | City          | Zip Code | Discount Code               |
      | România | Cluj     | Cluj-Napoca   | 398954   | I don't have any code       |
      | România | Botoşani | Botoşani      | 259877   | I don't have any code 789## |
      | România | Bihor    | Oradea        | 2559877  | 789## I don't have any code |
      | România | Cluj     | Campia-Turzii | 2559877  | 789##79595565               |


  Scenario: Products from shopping cart are also in mini-cart

    Given I open the homepage and I add products to cart
    When I click on mini-cart link to see the products
#      Flaviu
    Then the product lists are the same


  Scenario: Check the GRAND TOTAL price is right

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    When I add product to cart
        #Flaviu
    Then sum of SUB TOTAL price and TAX is the same as GRAND TOTAL price


  Scenario: Check the button EMPTY CART

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add product to cart
    When I click on empty cart
    Then I expect to shopping cart to by empty

  Scenario: check if the color of the product in product page is the same as shopping cart

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    When I add product to cart with color "Black"
    Then I expect the color to be the same


  Scenario: check if shopping can continue after shopping cart has been emptied

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add product to cart
    And I click on empty cart
    When I click to continue to shopping


  Scenario: Check DISCOUNT CODE with empty field

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add product to cart
    When I click the apply button
    Then I expect a warning message to fill the empty field


  Scenario: Check the button UPDATE SHOPPING CART

    Given I open the homepage
    And I open "Chelsea Tee" product page
    And I select the color "Black"
    And I select size "M"
    And I add product to cart
    And I change quantity in 4
    When  I click UPDATE SHOPPING CART
    Then I expect the quantity of product to change


#  //table[@id='shopping-cart-totals-table']//td[./preceding-sibling::td[.//*[text()='Grand Total']]]//span[@class='price']

#  //td[./preceding-sibling::td[.//*[text()[normalize-space(.)='Tax']]]]//span[@class='price']
#  //td[./preceding-sibling::td[normalize-space(text())='Subtotal']]//span[@class='price']
# //td[./preceding-sibling::td[.//*[contains(normalize-space(text()),'Grand Total')]]]//span[@class='price']












