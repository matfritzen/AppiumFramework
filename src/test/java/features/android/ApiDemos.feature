Feature: Validating ApiDemos application

@Android @Regression
Scenario Outline: Fill Wifi Name
  Given I select "Preference" option in the Home menu
  And I select "Preference Dependencies" in the Preference menu
  And I select the "WiFi" checkbox
  When I click on Wifi Settings button
  And Verify the alert title
  Then I fill the WiFi Name as "<wifi>"
  Examples:
    |wifi|
    |Matheus WiFi|
    |Abc Test|

@Android @Regression
Scenario: Drag and Drop scenario
  Given I select "Views" option in the Home menu
  And I select "Drag and Drop" in the Views menu
  When I drag and drop the image
  Then I verify the result message "Dropped!"

@Android @Regression
Scenario: Long Press Gesture
  Given I select "Views" option in the Home menu
  And I select "Expandable Lists" in the Views menu
  When I select "Custom Adapter" in the Expandable Lists menu
  Then I validate the "Sample menu" title

  @Android @Regression
  Scenario: Miscellaneous Appium Actions
    Given I select "Preference" option in the Home menu
    And I select "Preference Dependencies" in the Preference menu
    And I select the "WiFi" checkbox
    And I rotate the device
    And I click on Wifi Settings button
    And Verify the alert title
    When I copy the wifi name "Matheus Wifi" and paste
    Then I back to Home page of Android



