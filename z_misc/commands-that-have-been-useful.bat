@REM https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
@REM Maven projectcreation
call mvn archetype:generate  "-DarchetypeGroupId=io.cucumber" ^
  "-DarchetypeArtifactId=cucumber-archetype"    ^
   "-DarchetypeVersion=7.11.1"                  ^
   "-DgroupId=jl.testing"                       ^
   "-DartifactId=raravi-sudoku-app-testing"     ^
   "-Dpackage=testing"                          ^
   "-Dversion=1.0.0-SNAPSHOT"                   ^
   "-DinteractiveMode=false"


@REM Cypress installation
cd raravi-sudoku-app-testing
call npm install cypress --save-dev
npx cypress open