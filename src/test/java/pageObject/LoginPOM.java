package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM 
{
	public WebDriver driver;
	
	
	public LoginPOM(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement enterUserName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement enterPassword;
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement clickOnLoginBtn;
	
	public void enterUsernameText(String username)
	{
		enterUserName.sendKeys(username);
	}
	
	public void enterPasswordText(String password)
	{
		enterPassword.sendKeys(password);
	}
	public void clickOnLoginBtn()
	{
		clickOnLoginBtn.click();
	}
	
	@FindBy(xpath="//div[@id='login_credentials']/child::h4")
	private WebElement getTextFromLoginpage;
	
	public String getTextFromFromLoginpagee()
	{
		return getTextFromLoginpage.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
		
}
