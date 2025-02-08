package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutStep_OnePage extends TestBase

{
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastNameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipCoadTxtBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	

	public CheckOutStep_OnePage()   //consaturctor
	{
		PageFactory.initElements(driver, this);
	}
	
	public String information()
	{
	
		firstNameTxtBox.sendKeys("komal");
	    lastNameTxtBox.sendKeys("mane");
	    zipCoadTxtBox.sendKeys("412228");
	    continueBtn.click();
	    return driver.getCurrentUrl();
	    
	}
	
	
}
