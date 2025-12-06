Feature: Complete order feature 

Background: steps common for the scenario's
Given User Launch Chrome browser 
When User opens URL "https://www.saucedemo.com/" 
And User enters Username as "standard_user" and Password as "secret_sauce" 
And Click on Login button
Then user should be see text "Products" 

@Functional
Scenario: user is able to add product to cart 
    
	When user click on "Sauce Labs Bolt T-Shirt" product
	And user click on notification icon 
	Then user should be navigate to "Your Cart" page
	And product "Sauce Labs Bolt T-Shirt" should be added to cart
	When user click on the Checkout button
	And user added details in Checkout Your Information page
	And user cliick on the Continue button
	Then user should be see Checkout Overview details
	When user click on finish button
	Then user should be see "Thank you for your order!" message
	And close browser