#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
@selenium

Feature: Users login to into Swag Labs

  As a user I want to beable to visit the Swag Labs home page and login to use the website or be told
  why I cannot login.

  Scenario: Successfully logs-in to Swag Labs
    Given the users username 'standard_user'
    And password 'secret_sauce'
    When the user requests 'https://www.saucedemo.com/'
    And enters their login details
    Then they successfully login

  Scenario: Lockedout user gets told why they cannot login to Swag Labs
    Given the users username 'locked_out_user'
    And password 'secret_sauce'
    When the user requests 'https://www.saucedemo.com/'
    And enters their login details
    Then they cannot login
    And are told error 'Epic sadface: Sorry, this user has been locked out.'

  Scenario: User with incorrect passwored gets told why they cannot login to Swag Labs
    Given the users username 'problem_user'
    And password 'wrong'
    When the user requests 'https://www.saucedemo.com/'
    And enters their login details
    Then they cannot login
    And are told error 'Epic sadface: Username and password do not match any user in this service'
