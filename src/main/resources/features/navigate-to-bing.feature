#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Examples: Container for s table


@selenium
Feature: Navigate to Bing
  
  As a user, I want to navigate to Bing so that I can search the internet.

  Scenario: Successfully navigates to bing
    When the user requests 'https://www.bing.com'.
    Then the user should be on the Bing home page.