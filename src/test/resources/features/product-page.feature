Feature: Product page

  Scenario:Check price after was opened product page against the one from home page

    Given I open the homepage
    When Check the price and I open the product Chelsea Tee page
    Then the price must be the same

  Scenario: Check if the color of the product changes after selecting the color

    Given I open the homepage
    And I open the product Chelsea Tee page
    When I select the color black
    Then expect the color of the product to change in black


  Scenario: Check name after was opened product page against the one from home page

    Given I open the homepage
    When Check the name and I open the product Chelsea Tee page
    Then expect the name Chelsea Tee to be on both pages


  Scenario: Check the button review

    Given I open the homepage
    And I open the product Lafayette dress
    When I click on review button
    Then I expect to see reviews


  Scenario: Check the button Add your review

    Given I open the homepage
    And I open the product Lafayette dress
    When I click on Add your review
    Then I expect to be a field to write reviews


