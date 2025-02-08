package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase

{

	LoginPage login; 
	
@BeforeMethod(alwaysRun = true)
	
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test(groups = "regression")
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL = ReadData.readExcel(0, 0);//"https://www.saucedemo.com/";
		String actURL = login.verifyURLOfApplication();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Swag Labs URL = " +actURL);
	}
	
	

	@Test(groups = "sanity")
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle = ReadData.readExcel(0,2);//"Swag Labs";(0,2)
		String actTitle = login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("Swag Labs Title = " +actTitle);  
	}
	
	
	
	@Test(groups = "retest")
	public void loginToApplicationTest() throws IOException
	{
		String expURL = ReadData.readExcel(0,1);//"https://www.saucedemo.com/inventory.html";
		String actURL = login.loginToApplication();   //https://www.saucedemo.com/inventory.html
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Login successful =" +actURL);
	}
	
	@DataProvider(name="CredsForLogin")
	
	public Object [] [] getData()
	{
		return new Object[] []
				{
			
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
		
		    	};
	 }
	
	 @Test(dataProvider="CredsForLogin")
	    	
		public void loginToApplicationWithMultiCredsTest(String un,String password)
	{
		SoftAssert sa = new SoftAssert();
		String expURl = "https://www.saucedemo.com/inventory.html";
		String actURL = login.loginToApplicationWithMultiCreds(un, password);
		sa.assertEquals(expURl, actURL);
		sa.assertAll();
	}
	

	@AfterMethod(alwaysRun = true)
	
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.sc(it.getName());
		}
		
		report.flush();
		driver.close();
	}
	
	
	
	
}
