# vita-mojo

---------------------------- Primary focus areas -----------------------------
1. Scalability
2. Maintainability



-------------------------- API Automation ------------------------------------


Features added
1. API Automation framework based on RestAssured which can scale for hundreds and thousands of API endpoints
   1.1 Controller model, client model, API endpoint model, Base API Endpoint, ApiBaseTest etc
2. Logging using TestNg Reporter
3. API models for signup api and login api
4. Automated tests for signup api and login api
5. Gradle task for running tests in parallel

In order to run the API automation tests, please run the following command:

./gradlew :register-login:runTestsInParallel -Dtag="REGISTRATION_API_SMOKE"
./gradlew :register-login:runTestsInParallel -Dtag="LOGIN_API_SMOKE"


Test execution reports can be found under the following directories
register-login/build/LOGIN_SMOKE
register-login/build/REGISTRATION_SMOKE

TestNg classes
apitests.logintests.LoginApiTest
apitests.signuptests.SignupApiTest





-------------------------- UI Automation ------------------------------------

1. Page object model
2. UIBaseTest
3. Chrome/Firefox support
4. Uses TestNG instead of Cucumber (not familiar enough with cucumber for a 2 hr implementation)


To run the test cases from gradle, please use the following commands
./gradlew :register-login:runTestsInParallel -Dtag="LOGIN_UI_SMOKE"
./gradlew :register-login:runTestsInParallel -Dtag="REGISTRATION_UI_SMOKE"


Test execution reports can be found under the following directories
register-login/build/LOGIN_UI_SMOKE

TestNg classes
uitests.logintests.LoginUITest
uitests.registertests.RegisterUITest


Chrome driver and firefox driver instructions -> chromedriver and geckodriver should be placed in the src/main/resources directory of register-login module. 
src/main/resources directory already contains chromedriver.exe and geckodriver.exe. Hence the scripts will run out of the box from windows. 
In case if you are running from mac/linux, please download the drivers from the following links and place them in the src/main/resources directory
To switch between chrome browers and firefox browser, please update the browser field of ui-integration.properties file in the src/main/resources directory of register-login module. Supported values are chrome and firefox 