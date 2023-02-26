@REM This script is meant to be run by a process started by Java
@REM and will fail if run directly from a command prompt.
npx cypress run -b chrome --config screenshotOnRunFailure=false,video=false --spec "./cypress/e2e/US2.1-Level-easy-at-startup.cy.js"
