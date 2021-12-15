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
  
  As a user I want to beable to visit the Swag Labs home page and login to use the website.

  @tag1
  Scenario: Successfully logs into Swag Labs
    Given the users username ''
    And password ''
    When the user requests 'https://www.bing.com'
    And enters their login details
    Then they successfully login
