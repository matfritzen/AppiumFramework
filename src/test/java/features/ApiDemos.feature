Feature: Validating ApiDemos application

#  Background: User is already on

@Android @Regression
Scenario: Fill Wifi Name
  Given I select "Preference" option in the Home menu
  And I select "Preference Dependencies" in the Preference menu
  And I select the "WiFi" checkbox
  When I click on "Wifi Settings" button
  And Verify the alert title
  Then I fill the WiFi Name as "Matheus WiFi"
