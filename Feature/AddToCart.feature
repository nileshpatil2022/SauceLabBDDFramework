Feature: Login 

@Smoke
Scenario: Successful Login with Valid Credentials 
    Given User Launch Chrome browser 
	When User opens URL "https://www.saucedemo.com/" 
	And User enters Username as "standard_user" and Password as "secret_sauce" 
	And Click on Login button
	Then user should be see text "Products" 
	When user click on "Sauce Labs Bolt T-Shirt" product
	And user click on notification icon 
	Then user should be navigate to "Your Cart" page
	And product "Sauce Labs Bolt T-Shirt" should be added to cart
	And close browser