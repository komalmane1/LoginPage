package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventorypage;
import pages.LoginPage;
import pages.cartPage;
import utility.Screenshot;

public class cartPageTest extends TestBase

{
	 LoginPage login;
	 Inventorypage invent;
	 cartPage cart;
	 
	@BeforeMethod(alwaysRun = true)
	
	  public void setUp() throws InterruptedException, IOException
	    {
		
	     initialization();
	     login = new LoginPage();
	     invent = new Inventorypage();
	     cart = new cartPage();
		 login.loginToApplication();
		 invent.add6Product();
		 invent.clickoncartIcon();
	  }  
	
	
	@Test(groups = "retest")
	public void clickoncartTest()
	{
		String expUrl ="https://www.saucedemo.com/cart.html";
		String actUrl = invent.clickoncart();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("URL ="  +actUrl);
	}
	@Test(groups = "sanity")
	public void cartPageTitleTest()
	{
		String expTitle ="Your Cart";
		String actTitle = cart.cartPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of cart page is ="  +actTitle);
	}
	
	@Test(groups = {"regression","retest"})
	public void appLogoTest()
	{

		String expTitle ="Swag Labs";
		String actTitle = cart.appLogo();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(" Title of App Logo is ="  +actTitle);
	}
	
	@Test(groups = "regression")
	public void cartQuantityLableTest()
	{
		String expTitle ="QTY";
		String actTitle = cart.cartQuantityLable();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("cart Quantity Lable ="  +actTitle);
	}
	
	@Test(groups = "sanity")
	public void cartDiscriptionTest()
	{
		String expTitle ="Description";
		String actTitle = cart.cartDiscription();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(" Cart Description ="  +actTitle);
	}
	
	@Test(groups = "retest")
	public void continueshoppingBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL= cart.continueshoppingBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Continue Shopping ="+actURL);
	}
	
	
	
	
	
	 @AfterMethod(alwaysRun = true)
	   
	 public void closeBrowser(ITestResult it) throws IOException
		{
			if(it.FAILURE==it.getStatus())
			{
				Screenshot.sc(it.getName());
			}
			driver.close();
		}
	
}
