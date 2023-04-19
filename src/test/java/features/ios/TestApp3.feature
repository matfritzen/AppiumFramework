@Ios @Regression @TestApp3
Feature: Validating functionalities in the Test App 3


Scenario: Slide function
  Given I slide "0%" the slider
  Then I slide "0.5%" the slider
  And I slide "1%" the slider