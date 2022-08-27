## Selenide project

Project contains:
Selenide
Allure Report


## Running the tests under Maven
To run tests, perform:

    mvn clean verify -Denv=QA -Dbrowser=CHROME

env options: QA / DEV / ERR
browser options: CHROME / FIREFOX / EDGE

To check it works correctly, run this way (tests should fail because of wrong user password):

    mvn clean verify -Denv=ERR  -Dbrowser=FIREFOX


## Viewing the Allure Report
settings file: src/test/resources/allure.properties

To view test Allure Report after test run, please, perform: 

    mvn allure:serve