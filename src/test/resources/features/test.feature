Feature: Test

  Scenario: products list

    Given I open the homepage and I add products to cart
    When I click on mini-cart link to see the products
    Then jcsdonskcnsdklnsd


  Scenario: Check the button Add To Cart

    Given I open the homepage
    And I open "Elizabeth Knit Top" product page
    And I open the homepage
    And I open "Chelsea Tee" product page


  Scenario: Dynamic method

    Given I open the homepage
    And I go to "Women" category and I select "Pants & Denim"
    And I select product "TriBeCa Skinny Jean"
    And I select the color "Black"
    And I select size "28"
    And I add products to cart


    Scenario: List test

      Given I open the homepage and I add products to cart
      When I click on mini-cart link to see the products test

      Then the product lists are the same test
