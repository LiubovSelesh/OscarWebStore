## Description
OscarWebStore – online shop


## Testing purposes
[MapMup](https://drive.google.com/drive/u/0/folders/1pPzM9JAmvl_LC7h4RV5ptxIn0TjS0eKj)
[TestPlan](ttps://docs.google.com/spreadsheets/d/1GUaHDGnAsFCef9aW8JTgas8C2H0aqQ9cuJbIkHAsahI/edit#gid=1064942698)
[TesLink](https://testlink.telran-edu.de/index.php?caller=login&viewer=)
[ChekList](https://docs.google.com/spreadsheets/d/1GUaHDGnAsFCef9aW8JTgas8C2H0aqQ9cuJbIkHAsahI/edit#gid=1064942698)
Used Boundary Value Analysis  for [registration and login](https://docs.google.com/spreadsheets/d/1IxlSLqSF6JNzr3h7BRjnCgaxK3g10aeXICTbbwZosEM/edit#gid=732347812)

Pattern was created with Page Object
- BlackBox Testing,
- Nonfunctional
  • Usability
  
- Functional testing
  • Smoke testing
  
- Maintenance
  • Regression Testing
  
Use boundary value with csv file use DataProvider
Creating Package for running tests:
  • UI test- testngUI.xml  - gradlew clean testngUI
  • SmokeTest - testngSmoky.xml  - gradlew clean testSmoky
  • RegressionTest - testRegression.xml - gradlew clean testngRegression
- used the Headless method to speed up the testing process
