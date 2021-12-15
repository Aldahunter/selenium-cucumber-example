#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios

@selenium
Feature: Checkout items on secret sauce

	As a user, I want to add items to my basket so that I can purchase them.
	
	Background:
		Given the user is logged in
		
	Scenario: Should succesfully purchase items
	  When the user adds items to the cart
								  		| "Sauce Labs Backpack" 	|
											| "Sauce Labs Bike Light" |
		And the user navigates to the cart
		And the user proceeds to checkout
		And the user enters their details
		And the user proceeds to checkout overview
		And the user confirms the transaction
		Then a purchase verification should appear on the screen saying "THANK YOU FOR YOUR ORDER"