package testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventorypage;
import pages.LoginPage;


public class InventorypageTest extends TestBase

{
    LoginPage login;
	Inventorypage invent;
	
	@BeforeMethod(alwaysRun = true)
	
       public void setUp() throws InterruptedException, IOException
	    {
		     initialization();
		    login = new LoginPage();
		    invent = new Inventorypage();
		    login.loginToApplication();
	    }   
	
	@Test (groups = "sanity")
	public void verifyTitleOfApplicationTest()
	{
		String expTitle = "Swag Labs";
		String actTitle = login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("Swag Labs Title = " +actTitle);
	}
	
	@Test (groups = "retest")
	public void verifyProductTxtTest()
	{
		boolean result = invent.verifyProductTxt();
		Assert.assertEquals(result, true);
		Reporter.log("Prodeuct title text is present =" +result);
	}
	
	@Test (/*priority = 3,enabled=false*/)
	public void verifyTwitterLogoTest()
	{
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter logo is present = " +result);
				
	}
	       	
    @Test (groups = {"sanity","retest"})
    public void  verifyFaceBookLogoTest()
    {
    	boolean result = invent.verifyFaceBookLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("FaceBook logo is present = " +result);
    }
    
    @Test (groups = "regression")
    public void verifyLinkedInLogoTest()
    {
    	boolean reuslt = invent.verifyLinkedInLogo();
    	Assert.assertEquals(reuslt, true);
    	Reporter.log("LinkedIn logo is present = " +reuslt);
    }
    
    
    @Test(groups = "sanity")
    public void verifyfooterTest()
    {
    	String expTxt = "© 2025 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
    	String actTxt = invent.verifyfooter();
    	Assert.assertEquals(expTxt, actTxt);
    	Reporter.log("Footer lable =" +actTxt);
    }
    
    @Test (groups = "regression")
    public void add6ProductTest() throws InterruptedException
    {
    	String expCount = "6";  //6
    	String actCount = invent.add6Product();
    	Assert.assertEquals(expCount, actCount);
    	Reporter.log("Total Products add to =" +actCount);
    }
    
    @Test(groups = {"regression","sanity"})
    public void remove6Products() throws InterruptedException
    {
    	String expC="5";//5
    	String actC= invent.remove6Products();
    	Assert.assertEquals(expC, actC);
    	Reporter.log("Remove Product count =" +actC);
    }
    
    
    
   @AfterMethod(alwaysRun = true)
   
   public void closeBrowser()
	{
		driver.close();
	}

}
