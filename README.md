## Description
OscarWebStore – online shop


## Testing purposes
[MapMup](https://drive.google.com/drive/u/0/folders/1pPzM9JAmvl_LC7h4RV5ptxIn0TjS0eKj)
TestPlan –[TesLink](bit.ly/3VGDk7V)
[ChekList](bit.ly/3IzPKvx)
Used [Boundary Value] Analysis  for registration and login Tests (bit.ly/3Qab2S3)

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
