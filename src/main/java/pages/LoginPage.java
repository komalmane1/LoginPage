package pages;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase

{
	//object repository
	@FindBy(xpath="//input[@name='user-name']") private WebElement userNameTxtBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTxtBox;
	@FindBy(xpath ="//input[@id='login-button']") private WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public String loginToApplication() throws IOException
	
	{
		
		logger=report.createTest("Login to sauce lab application");
		userNameTxtBox.sendKeys("standard_user");
		logger.log(Status.INFO, "User name is entered");
		
		passwordTxtBox.sendKeys("secret_sauce");
		logger.log(Status.INFO, "Password is entered");
		
		loginBtn.click();
		logger.log(Status.INFO, "Login button is clicked");
		logger.log(Status.PASS, "Login successful");
		
		return driver.getCurrentUrl();   //https://www.saucedemo.com/inventory.html

		
	}
	
	public String loginToApplicationWithMultiCreds(String un,String password)
	{
		userNameTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		return driver.getCurrentUrl();
	}

	
	
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}

}



