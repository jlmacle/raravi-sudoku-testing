Feature: 3 levels of difficulty : Easy, Medium and Hard

    Scenario: US 2.1-a: Levels : When the application starts, the level is set on "Easy" [Chrome]
        When "Chrome" is on the homepage
        Then The default level is easy ["Chrome"]

    Scenario: US 2.1-b: Levels : When the application starts, the level is set on "Easy" [Edge]
        When "Edge" is on the homepage
        Then The default level is easy ["Edge"]
       
    Scenario: US 2.2-1: Levels: When clicking on "Easy", "Medium" should be visible, selectable and "Easy" should not be visible anymore [Edge]
        When "Edge" is on the homepage, and I click on the level "Easy"
        Then "Medium" should be visible, selectable and Easy should not be visible anymore
        

    