package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObject.AddToCartPOM;
import pageObject.HomePOM;
import pageObject.LoginPOM;
import utilities.ReadConfig;

import org.apache.logging.log4j.*;

public class BaseClass 
{
	public WebDriver driver;
	public ChromeOptions option;
	public LoginPOM lg;
	public HomePOM hm;
	public AddToCartPOM addToCart;
	
	public ReadConfig read;
	
	public static Logger log;

}
