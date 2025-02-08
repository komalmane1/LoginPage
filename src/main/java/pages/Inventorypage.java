package pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDown;



public class Inventorypage extends TestBase

{
   //object repository
	@FindBy(xpath="//span[contains(text() ,'Products')]") private WebElement productTxt;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement faceBookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedInLogo;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement footer;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikelightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement tshirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleecejacketProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement labsonesieProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement allthethingsProduct;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropdownlist;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removefleecejacketProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpackProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removetshirtProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeallthethingsProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikelightProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removelabsonesieProduct;

	
	public Inventorypage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyProductTxt()
	{
		return productTxt.isDisplayed();
	}
	
	public boolean verifyTwitterLogo()
	  {
		  return twitterLogo.isDisplayed();
	  }
	
	public boolean verifyFaceBookLogo()
		  
    	{
		  return faceBookLogo.isDisplayed();
		
     	}
	public boolean verifyLinkedInLogo()
	  {
		  return linkedInLogo.isDisplayed();
	  }
	public String verifyfooter()
	{
		return footer.getText();
	}
	
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}	
	
	public String add6Product() throws InterruptedException
	{
		HandleDropDown
		.handleSelect(dropdownlist, "Price (high to low)");
		Thread.sleep(5000);
		backpackProduct.click();
		bikelightProduct.click();
		tshirtProduct.click();
		fleecejacketProduct.click();
		labsonesieProduct.click();
		allthethingsProduct.click();
		return cartCount.getText();
	}
	
	public String remove6Products() throws InterruptedException
	{
		add6Product();
		Thread.sleep(5000);
		removefleecejacketProduct.click();
		Thread.sleep(5000);
		return cartCount.getText();
	}
	public void clickoncartIcon()
	{
		cartIcon.click();
		
	}
	
	public String clickoncart()
	{
		return driver.getCurrentUrl();  //https://www.saucedemo.com/cart.html
				
		
	}
}
