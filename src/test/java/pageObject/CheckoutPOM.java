package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPOM 
{
	public WebDriver driver;
	
	public CheckoutPOM(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	//user information
	
	@FindBy(xpath="//input[@id='first-name']	")
	private WebElement fName;
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement LName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement PinCode;
	
	
	public void sendFirstName(String Firstname)
	{
	
		fName.click();
		fName.sendKeys(Firstname);
	}

	public void sendLastName(String LastName)
	{
		LName.clear();
		LName.sendKeys(LastName);
	}
	
	public void sendPinCode(String pinCode)
	{
		PinCode.click();
		PinCode.sendKeys(pinCode);
	}
	
	//click on continue button
	@FindBy(xpath="//input[@id='continue']")
	private WebElement clickOnContinueBtn1;
	
	public void clickOnContinueBtn()
	{
		clickOnContinueBtn1.click();
	}
	
	
	@FindBy(xpath="(//div[@class='summary_info_label'])[1]")
	private WebElement paymentText;
	
	
	public String getPaymentText()
	{
	  return	(paymentText.getText());
	}
	
	
	@FindBy(xpath="//button[@class='btn btn_action btn_medium cart_button']")
	private WebElement clickOnFinishBtn;
	
	
	public void clickOnFinishBtn()
	{
		clickOnFinishBtn.click();
	}
	
	@FindBy(xpath="//h2[@class='complete-header']")
	private WebElement ThanksMessageText;
	
	
	public String getThanksMessageText()
	{
	  return	(ThanksMessageText.getText());
	}
	
	
	
}
