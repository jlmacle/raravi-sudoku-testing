cd ../../../
call npx cypress run -b chrome --config screenshotOnRunFailure=false,video=false --spec "./cypress/e2e/US2.1-Level-easy-at-startup.cy.js"
cd cypress/e2e/scripts