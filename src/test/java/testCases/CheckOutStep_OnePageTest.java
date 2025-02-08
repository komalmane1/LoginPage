package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CheckOutStep_OnePage;
import pages.Inventorypage;
import pages.LoginPage;
import pages.cartPage;
import utility.Screenshot;

public class CheckOutStep_OnePageTest extends TestBase

{
	 LoginPage login;
	 Inventorypage invent;
	 cartPage cart;
	 CheckOutStep_OnePage check1;
	 
	 
	@BeforeMethod(alwaysRun = true)
	
	  public void setUp() throws InterruptedException, IOException
	    {
		
	     initialization();
	     login = new LoginPage();
	     invent = new Inventorypage();
	     cart = new cartPage();
	     check1=new CheckOutStep_OnePage();
		 login.loginToApplication();
		 invent.add6Product();
		 invent.clickoncartIcon();
		 cart.checkOutBtnclick();
	  }  

	@Test(groups = "regression")
	public void information()
	{
		String expURl="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check1.information();
		Assert.assertEquals(expURl, actURL);
		Reporter.log("Checkout two page ="+actURL);
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
