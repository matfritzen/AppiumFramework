@Ios @Regression @Photos @Test
Feature: Validating Swipe Functionality in Photos app

  Scenario: Swipe Function
    Given I click on "All Photos" option in Photos app
    Then I swipe the photos
    And I click on "Back" button in Photos app
    And I click on "Albums" option in Photos app