package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddToCartPOM;
import pageObject.HomePOM;
import pageObject.LoginPOM;


public class StepDef 
{
	public WebDriver driver;
	public ChromeOptions option;
	public LoginPOM lg;
	public HomePOM hm;
	public AddToCartPOM addToCart;
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		option =new ChromeOptions();
		option.addArguments("--incognito");
		
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
	    driver.get(URL);
	}

	@And("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		lg=new LoginPOM(driver);
	   lg.enterUsernameText(username);
	   lg.enterPasswordText(password);
	}

	@And("Click on Login button")
	public void click_on_login() {
	    lg.clickOnLoginBtn();
	}

	@Then("user should be see text {string}")
	public void user_should_be_see_text(String expectedResult) 
	{
		hm=new HomePOM(driver);
		
		String actualResult=hm.getTextAfterLogin();
		
		if(actualResult.equals(expectedResult))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

		////////////////////////////////Add to cart page//////////////////////////////////
		
		
		
		@When("user click on {string} product")
		public void user_click_on_product(String string) {
		   hm.addCartBtnClick();
		}

		@And("user click on notification icon")
		public void user_click_on_notification_icon() {
		   hm.clickOnnNtificationIcon();
		}

		@Then("user should be navigate to {string} page")
		public void user_should_be_navigate_to_page(String expected) {
			addToCart=new AddToCartPOM(driver);
		 
		String actual= addToCart.getTextFromCartPage();
		 
		 if(actual.equals(expected))
		 {
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.assertTrue(false);
		 }
		  
		  
		}

		@And("product {string} should be added to cart")
		public void product_should_be_added_to_cart(String expected)
		{
			String actual=addToCart.textFromProduct();
			
			
			if(actual.equals(expected))
			 {
				 Assert.assertTrue(true);
			 }
			 else
			 {
				 Assert.assertTrue(false);
			 }
			  
			  
			}
		    

	@And("close browser")
	public void close_browser() {
		driver.close();
	    
	}

}
