Feature: Happy Path End-to-End Purchase Flow 

  
Scenario: Successful purchase of a single product
    Given I login as a standard user
    When I add “Sauce Labs Backpack” to the cart
    And I checkout with valid customer details
    Then I should see the order confirmation page
    
Scenario: Invalid login shows error 
	Given I attempt login with invalid credentials
	Then I should see an authentication error message

  
