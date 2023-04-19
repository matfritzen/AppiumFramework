@Ios @Regression @UIKitCatalogue
Feature: Validating UIKitCatalogue Workflow

  @Ios @Test
  Scenario: Validating Alert View functionality
    Given I select "Alert Views" option in the Home Page
    And I select "Text Entry" in the Alert Views screen
    And I get the "confirm" message
    When I fill the text label with "Hello World"
    Then I click to "accept" the pop up

 @Ios @Test
  Scenario: Long Press action
    Given I select "Steppers" option in the Home Page
    Then I long press the increment in "Custom" field


  Scenario: Scroll action
    Given I select "Picker View" option in the Home Page
    Then I scroll the "first" number to 80
    And I scroll the "second" number to 220
    And I scroll the "third" number to 105