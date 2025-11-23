package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddToCartPOM;
import pageObject.HomePOM;
import pageObject.LoginPOM;
import utilities.ReadConfig;



public class StepDef extends BaseClass
{

	@Before
	public void setUp() throws IOException
	{
		read =new ReadConfig();
		//initialize logger
		log=LogManager.getLogger("StepDef");
		
		
		
		String browser= read.getBrowser();
		switch(browser.toLowerCase())
		{
		case "chrome": 
		
			//option =new ChromeOptions();
			//option.addArguments("--incognito");
			driver=new ChromeDriver();
			break;
			
		case "msedge":
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			driver=new FirefoxDriver();
			break;
			
		default:
			driver=null;
			break;
			
		}
		
		
		
		
		
		log.info("setUp method executed");
	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		
		log.info("Browser launched");
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
	    driver.get(URL);
	    
	    log.info("opened the sauce lab application URL");
	}

	@And("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		lg=new LoginPOM(driver);
	   lg.enterUsernameText(username);
	   
	   log.info("user entered the username");
	   lg.enterPasswordText(password);
	   
	   log.info("user entered the password");
	}

	@And("Click on Login button")
	public void click_on_login() {
	    lg.clickOnLoginBtn();
	    log.info("user clicked on login button");
	}

	@Then("user should be see text {string}")
	public void user_should_be_see_text(String expectedResult) 
	{
		hm=new HomePOM(driver);
		
		String actualResult=hm.getTextAfterLogin();
		
		if(actualResult.equals(expectedResult))
		{
			Assert.assertTrue(true);
			
			log.warn("Test passed: user is on home page");
		}
		else
		{
			Assert.assertTrue(false);
			
			log.warn("Test failed: login feature failed");
			
		}
	}

		////////////////////////////////Add to cart page//////////////////////////////////
		
		
		
		@When("user click on {string} product")
		public void user_click_on_product(String string) {
		   hm.addCartBtnClick();
		   
		   log.info("user clicked on product link");
		   
		}

		@And("user click on notification icon")
		public void user_click_on_notification_icon() {
		   hm.clickOnnNtificationIcon();
		   
		   log.info("user clicked on notification icon");
		}

		@Then("user should be navigate to {string} page")
		public void user_should_be_navigate_to_page(String expected) {
			addToCart=new AddToCartPOM(driver);
		 
		String actual= addToCart.getTextFromCartPage();
		 
		 if(actual.equals(expected))
		 {
			 Assert.assertTrue(true);
			 log.warn("Test passed: user is navigated to cart page");
		 }
		 else
		 {
			 Assert.assertTrue(false);
			 log.warn("Test failed: user unable to navigated to cart page");
		 }
		  
		  
		}

		@And("product {string} should be added to cart")
		public void product_should_be_added_to_cart(String expected)
		{
			String actual=addToCart.textFromProduct();
			
			
			if(actual.equals(expected))
			 {
				 Assert.assertTrue(true);
				 log.warn("Test passed: user is able to see selected product is added to cart page");
			 }
			 else
			 {
				 Assert.assertTrue(false);
				 log.warn("Test failed: product is not added to cart page");
			 }
			  
			  
			}
		
		
	////////////////////logout feature//////////////////////
		@When("user click  on the main icon")
		public void user_click_on_the_main_icon() {
			hm.clickOnmainIcon();
			
			log.info("user clicked on main icon");
			
		}

		@When("user click on logout button")
		public void user_click_on_logout_button() {
			hm.clickOnLogoutLink();
			log.info("user clicked on logout button");
		}

		@Then("user should be navigate to login page")
		public void user_should_be_navigate_to_login_page() {
		  
			if(lg.getTextFromFromLoginpagee().equals("Accepted usernames are:"))
			{
				Assert.assertTrue(true);
				log.warn("Test passed: user is navigate to login page");
			}
			else
			{
				Assert.assertTrue(false);
				log.warn("Test failed:user is unable to navigate to login page ");
			}
			
			
		}

	@And("close browser")
	public void close_browser() {
		driver.close();
		
		log.info("Browser is closed");
	    
	}

	@After
	public void tearDown(Scenario sc) throws IOException
	{
		if(sc.isFailed()==true)
		{
			Date d=new Date();
			
			DateFormat d1=new SimpleDateFormat("yyyyMMdd_HHmmss");
			String timestamp=d1.format(d);
			
			
			
			//String path=".//screenshot/failtedTCScreenshot.jpg";
			
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			File souceFile=ts.getScreenshotAs(OutputType.FILE);
			
			File location=new File(".//screenshot/failedTCScreenshot"+ timestamp + ".jpg");
			
			FileHandler.copy(souceFile, location);
		}
			
		driver.quit();
	}
}
