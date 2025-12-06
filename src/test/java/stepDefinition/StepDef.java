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
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddToCartPOM;
import pageObject.CheckoutPOM;
import pageObject.HomePOM;
import pageObject.LoginPOM;
import utilities.ReadConfig;

public class StepDef extends BaseClass {

	@Before
	public void setUp() throws IOException {
		read = new ReadConfig();
		// initialize logger
		log = LogManager.getLogger("StepDef");

		String browser = read.getBrowser();
		switch (browser.toLowerCase()) {
		case "chrome":

			option =new ChromeOptions();
			option.addArguments("--incognito");
			driver = new ChromeDriver();
			break;

		case "msedge":
			driver = new EdgeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			driver = null;
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
		lg = new LoginPOM(driver);
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
	public void user_should_be_see_text(String expectedResult) {
		hm = new HomePOM(driver);

		String actualResult = hm.getTextAfterLogin();

		if (actualResult.equals(expectedResult)) {
			Assert.assertTrue(true);

			log.warn("Test passed: user is on home page");
		} else {
			Assert.assertTrue(false);

			log.warn("Test failed: login feature failed");

		}
	}

	//////////////////////////////// Add to cart
	//////////////////////////////// page//////////////////////////////////

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
		addToCart = new AddToCartPOM(driver);

		String actual = addToCart.getTextFromCartPage();

		if (actual.equals(expected)) {
			Assert.assertTrue(true);
			log.warn("Test passed: user is navigated to cart page");
		} else {
			Assert.assertTrue(false);
			log.warn("Test failed: user unable to navigated to cart page");
		}

	}

	@And("product {string} should be added to cart")
	public void product_should_be_added_to_cart(String expected) {
		String actual = addToCart.textFromProduct();

		if (actual.equals(expected)) {
			Assert.assertTrue(true);
			log.warn("Test passed: user is able to see selected product is added to cart page");
		} else {
			Assert.assertTrue(false);
			log.warn("Test failed: product is not added to cart page");
		}

	}

	//////////////////// logout feature//////////////////////
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

		if (lg.getTextFromFromLoginpagee().equals("Accepted usernames are:")) {
			Assert.assertTrue(true);
			log.warn("Test passed: user is navigate to login page");
		} else {
			Assert.assertTrue(false);
			log.warn("Test failed:user is unable to navigate to login page ");
		}

	}

	// @After
//	public void tearDown(Scenario sc) throws IOException
//	{
//		if(sc.isFailed()==true)
//		{
//			Date d=new Date();
//			
//			DateFormat d1=new SimpleDateFormat("yyyyMMdd_HHmmss");
//			String timestamp=d1.format(d);
//			
//			
//			
//			//String path=".//screenshot/failtedTCScreenshot.jpg";
//			
//			
//			TakesScreenshot ts=(TakesScreenshot)driver;
//			
//			File souceFile=ts.getScreenshotAs(OutputType.FILE);
//			
//			File location=new File(".//screenshot/failedTCScreenshot"+ timestamp + ".jpg");
//			
//			FileHandler.copy(souceFile, location);
//		}
//			
//		driver.quit();
//	}
	
	//////////////////////////////Complete Payment///////////////////////////////////////
	@When("user click on the Checkout button")
	public void user_click_on_the_checkout_button() {
		
		addToCart.clickOncheckOutBtn();
		
		log.info("user clicked on checkedOut button");
	}

	@And("user added details in Checkout Your Information page")
	public void user_added_details_in_checkout_your_information_page() throws InterruptedException {
		checkOut=new CheckoutPOM(driver);
		
		Thread.sleep(2000);
		checkOut.sendFirstName("test1");
		log.info("User enters information: Firstname");
		Thread.sleep(2000);
		checkOut.sendLastName("test2");
		log.info("User enters information: LastName");
		Thread.sleep(2000);
		checkOut.sendPinCode("23456");
		log.info("User enters information: PinCode");
		
	}

	@And("user cliick on the Continue button")
	public void user_cliick_on_the_continue_button() {
		checkOut.clickOnContinueBtn();
		log.info("User clicked on continue button");
	}

	@Then("user should be see Checkout Overview details")
	public void user_should_be_see_checkout_overview_details() {
		
	
		String expectedResult="Payment Information:";
		String actualResult=checkOut.getPaymentText();
		if(actualResult.contentEquals(expectedResult))
		{
			Assert.assertTrue(true);
			log.warn("test passed: user is navigated to Payment Information page");
		}
		else
		{
			Assert.assertTrue(false);
			log.warn("test failed: user is unable to navigated to Payment Information page");
		}
		
	}

	@When("user click on finish button")
	public void user_click_on_finish_button() {
		checkOut.clickOnFinishBtn();
		log.info("User clicked on finish button");
		
	}

	@Then("user should be see {string} message")
	public void user_should_be_see_message(String expectedResult) {
		
		
		
		if(checkOut.getThanksMessageText().equals(expectedResult))
		{
			Assert.assertTrue(true);
			log.warn("test passed: user can see order successful message");
		}
		else
		{
			Assert.assertTrue(false);
			log.warn("test passed: user unable to see order successful message");
		}
	}

//	@After
//	public void addScreenshot(Scenario sc) {
//		if (sc.isFailed() == true) {
//			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//			sc.attach(screenshot, "image/png", sc.getName());
//
//		}
//
//		driver.quit();
//
//	}

}
