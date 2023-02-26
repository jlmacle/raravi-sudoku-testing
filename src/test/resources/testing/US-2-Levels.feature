Feature: 3 levels of difficulty : Easy, Medium and Hard

    Scenario: US 2.1-a: Levels : When the application starts, the level is set on "Easy" [Chrome]
        When "Chrome" is on the homepage
        Then The default level is easy ["Chrome"]

    Scenario: US 2.1-b: Levels : When the application starts, the level is set on "Easy" [Edge]
        When "Edge" is on the homepage
        Then The default level is easy ["Edge"]
       
    # Scenario: US 2.2: Levels: Accessibility of the levels "Medium" and "Hard" 
    #     When I click on the level "Easy"
    #     Then I can access the levels "Medium" and "Hard"
        

    