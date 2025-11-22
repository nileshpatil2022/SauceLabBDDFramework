Feature: Login 


Scenario: Successful Login with Valid Credentials 
    Given User Launch Chrome browser 
	When User opens URL "https://www.saucedemo.com/" 
	And User enters Username as "standard_user" and Password as "secret_sauce" 
	And Click on Login button
	Then user should be see text "Products"  
	And close browser
	
	@Regression
	Scenario Outline: Successful Login with Valid Credentials DDT 
	Given User Launch Chrome browser 
	When User opens URL "https://www.saucedemo.com/" 
	And User enters Username as "<username>" and Password as "<password>"
	And Click on Login button
	Then user should be see text "Products"  
	And close browser  	
	
	
	Examples:
	| username | password |
	|standard_user | secret_sauce |
	|locked_out_user | secret_sauce |
	|problem_user | secret_sauce |
	|performance_glitch_user | secret_sauce |
	|error_user | secret_sauce |
	|visual_user | secret_sauce |
	
