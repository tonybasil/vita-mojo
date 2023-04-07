# vita-mojo


In order to run the API automation tests, please run the following command:

./gradlew :register-login:runTestsInParallel -Dtag="REGISTRATION_SMOKE"
./gradlew :register-login:runTestsInParallel -Dtag="LOGIN_SMOKE"


Test execution reports can be found under the following directories
register-login/build/LOGIN_SMOKE
register-login/build/REGISTRATION_SMOKE
