@smoke
Feature: users could use login functionality to use their accounts

# Test Scenario 1 :
  Scenario: user could login with valid email and password
 Given user go to login page
    When user login "testmena3@example.com" and "P@ssw0rd"
    And user press on login button
    Then user could login to the system


# Test Scenario 2 :
  Scenario: user could login with invalid email and password
    Given user go to login page
    When user login "wrong@example.com" and "P@ssw0rd"
    And user press on login button
    Then user could not login to the system