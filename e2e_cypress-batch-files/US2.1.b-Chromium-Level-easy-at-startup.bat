@REM This script is meant to be run by a process started by Java
@REM and will fail if run directly from a command prompt.
npx cypress run -b chromium --config screenshotOnRunFailure=false,video=false --spec "./cypress/e2e/US2.1.a-Chrome-Level-easy-at-startup.cy.js"
