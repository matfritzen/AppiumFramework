@Android @Regression @Ecommerce
Feature: Validating Ecommerce Workflow


  Scenario: Fill form correctly
    Given I select the country "Argentina"
    And I fill the Name field with "Test"
    And I select the gender "Female"
    When I click on Lets Shop button
    Then I verify user is on "Products" page


  Scenario: Fill form with no name
    Given I select the country "Argentina"
    And I select the gender "Female"
    When I click on Lets Shop button
    Then I verify the error message for "user with no name"


  Scenario: Submit Order
    Given I fill the form correctly
    And I add the product "Air Jordan 4 Retro" in the cart
    And I add the product "Jordan 6 Rings" in the cart
    And I validate the products in the cart
    And I validate the total amount
    When I accept the terms and conditions
    Then I submit the order


  Scenario: Hybrid Test
    Given I fill the form correctly
    And I add the product "Air Jordan 4 Retro" in the cart
    And I add the product "Jordan 6 Rings" in the cart
    And I validate the products in the cart
    And I validate the total amount
    When I accept the terms and conditions
    Then I submit the order
    And I search "test" in the google page






