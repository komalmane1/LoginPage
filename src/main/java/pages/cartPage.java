package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class cartPage extends TestBase
{
    @FindBy(xpath="//div[@class='app_logo']") private WebElement appLogo;
	@FindBy(xpath="//span[@class='title']") private WebElement cartTitle;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement cartQuantityLable;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement cartDiscription;
	@FindBy(xpath="//button[@id='continue-shopping']") private WebElement continueshoppingBtn;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkOutBtn;
	 
	
	public cartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String appLogo()
	{
		return appLogo.getText();
	}
	public String cartPageTitle()
	{
		return cartTitle.getText();
	}
	
	public String cartQuantityLable()
	{
		return cartQuantityLable.getText();
	}
	public String cartDiscription()
	{
		return cartDiscription.getText();
	}
	public String continueshoppingBtn()
	{
		continueshoppingBtn.click();
	
		return driver.getCurrentUrl();
	
	}
	public void checkOutBtnclick()
	{
		checkOutBtn.click();
		
	}
	
	
	
	
}
