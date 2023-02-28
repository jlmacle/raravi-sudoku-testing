Feature: Used to add more commits
    Scenario: 0-1: 3000 in the port number
        When "Chrome" is on the homepage
        Then The port number is 3000 ["Chrome"]

    Scenario: 0-2: Sudoku on the page
        When "Chrome" is on the homepage
        Then Sudoku is on the page

    Scenario: 0-3: New game is on the page
        When "Chrome" is on the homepage
        Then New game is on the page

    

    