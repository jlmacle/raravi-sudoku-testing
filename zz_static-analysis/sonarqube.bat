:: -DskipTests=true to have the static analysis done even if the tests fail

cd ..

mvn clean -DskipTests=true verify sonar:sonar ^
  -Dsonar.projectKey=Sodoku-application-testing ^
  -Dsonar.host.url=http://127.0.0.1:9000 ^
  -Dsonar.login=%CT_SUDOKU_APP_TESTING-SONARQUBE%

@REM Path: z_static-analysis\sonarqube.bat