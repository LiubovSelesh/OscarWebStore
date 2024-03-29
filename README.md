## Description
OscarWebStore – online shop
This project has been developed with a combination of manual and automation testing. I have used Selenium with the Page Object Model to automate the testing process and Gradle as our build tool.

Smoke testing was performed to ensure that the critical functionalities of the application were working as expected. Regression testing was also conducted to ensure that any changes made to the code did not introduce any new bugs or break existing functionality.


## Testing purposes
[MindMup](https://drive.google.com/drive/u/0/folders/1pPzM9JAmvl_LC7h4RV5ptxIn0TjS0eKj)

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
- used the Headless method to speed up the te