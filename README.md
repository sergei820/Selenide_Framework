## Selenide project

Project contains:
Selenide
Allure Report


## Running the tests under Maven
To run tests, perform:

    mvn clean verify -Denv=QA

To check it works correctly, run this way (tests should fail because of wrong user password):

    mvn clean verify -Denv=ERR


## Viewing the Allure Report
settings file: src/test/resources/allure.properties

to view the report perform in cmd:

powershell
allure serve *full path to target/allure-results*