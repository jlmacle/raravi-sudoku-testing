@REM This script is meant to be run by a process started by Java
@REM and will fail if run directly from a command prompt.
npx cypress run -b edge --config screenshotOnRunFailure=false,video=false --spec "./cypress/e2e/2.Levels/US2.1-Visibility-of-level-easy-at-startup.cy.js"
