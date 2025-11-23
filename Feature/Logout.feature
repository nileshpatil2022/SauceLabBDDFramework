Feature: Logout 

@Test
Scenario: user is able to successfully logout from  application 
    Given User Launch Chrome browser 
	When User opens URL "https://www.saucedemo.com/" 
	And User enters Username as "standard_user" and Password as "secret_sauce" 
	And Click on Login button
	Then user should be see text "Products" 
	When user click  on the main icon
	And user click on logout button
	Then user should be navigate to login page