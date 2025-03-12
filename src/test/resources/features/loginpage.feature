Feature: Login Functionality for my application
  As a user I want to login to my application

  Background:
  Given Im already in the login page


  Scenario: Successful Login with Valid Credentials
    Given I have entered valid credentials
    When I click on the Login button
    Then I should see the home page


  Scenario Outline: Unsuccessful Login with Invalid Credentials
    Given I have entered an invalid "<username>" and "<password>"
    When I click on the Login button
    Then I should see the error message indicating "<error_message>"

    Examples:
      | username     | password | error_message                                                             |
      | invaliduser  | hate     | Epic sadface: Username and password do not match any user in this service |
      | otherinavlid | mate     | Epic sadface: Username and password do not match any user in this service |
