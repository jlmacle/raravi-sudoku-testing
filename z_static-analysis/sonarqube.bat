cd ..

mvn clean verify sonar:sonar ^
  -Dsonar.projectKey=Sodoku-application-testing ^
  -Dsonar.host.url=http://127.0.0.1:9000 ^
  -Dsonar.login=%CT_MAVEN_SUDOKU_APP_TESTING%

@REM Path: z_static-analysis\sonarqube.bat