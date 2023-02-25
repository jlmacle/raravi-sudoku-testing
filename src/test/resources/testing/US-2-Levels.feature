Feature: 3 levels of difficulty : Easy, Medium and Hard

    Scenario: US 2.1: Levels : When the application starts, the level is set on "Easy"
        When The browser is on the home page
        Then The default level is "Easy"
       
    # Scenario: US 2.2: Levels: Accessibility of the levels "Medium" and "Hard" 
    #     When I click on the level "Easy"
    #     Then I can access the levels "Medium" and "Hard"
        