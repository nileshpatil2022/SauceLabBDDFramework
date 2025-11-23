package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePOM
{
    public WebDriver driver;
	
	
	public HomePOM(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement afterLoggedInText;
	
	public String getTextAfterLogin()
	{
		return afterLoggedInText.getText();
	}

	
	@FindBy(xpath="//div[text()='Sauce Labs Bolt T-Shirt']/ancestor::div[@class='inventory_item']/descendant::button[text()='Add to cart']")
	private WebElement addCartBtn;
	
	public void addCartBtnClick()
	{
		addCartBtn.click();
	}
	
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
    private WebElement notificationIcon;
	
	public void clickOnnNtificationIcon()
	{
		notificationIcon.click();
	}
	
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	private WebElement mainIconclick;
	
	public void clickOnmainIcon()
	{
		mainIconclick.click();;
	}
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	private WebElement logoutLink;
	
	public void clickOnLogoutLink()
	{
		logoutLink.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
