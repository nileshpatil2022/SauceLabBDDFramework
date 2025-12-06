package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPOM {

	  public WebDriver driver;
		
		
		public AddToCartPOM(WebDriver driver)
		{
			this.driver=driver;
			
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(xpath="//span[@class='title']")
		private WebElement getCartPageText;
		
		public String getTextFromCartPage()
		{
			return getCartPageText.getText();
		}
		
		@FindBy(xpath="//div[@class='inventory_item_name']")
		private WebElement productText;
		
		public String textFromProduct()
		{
			return productText.getText();
		}
		
		
		
		//checkout button
		@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button ']")
		private WebElement checkOutBtn;
		
		public void clickOncheckOutBtn()
		{
			checkOutBtn.click();
		}
		
		
		
}
