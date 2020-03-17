Feature: Products Sorting
  As a customer
  I want to sort products by different criteria
  In order to easily find what I need

  Scenario: Sort product by price
    Given I open the homepage
    And I search products by "vase"
    #And I search products by "camera"
    When I sort products by "Price" in descending order
    Then all products are sorted by "price" in descending order
#
  Scenario Outline: Sort product by different criteria
    Given I open the homepage
    And I search products by "vase"
    #And I search products by "camera"
    When I sort products by "<sort criteria>" in <sort direction> order
    Then all products are sorted by "<sort criteria>" in <sort direction> order

    Examples:
      | sort criteria | sort direction |
      | Price         | descending     |
      | Price         | ascending      |
      | Name          | descending     |
      | Name          | ascending      |
