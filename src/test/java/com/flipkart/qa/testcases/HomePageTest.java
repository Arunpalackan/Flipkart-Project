package com.flipkart.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.ItemPage;
import com.flipkart.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	ItemPage itempage;
	LoginPage loginpage;
	
	public HomePageTest() throws Exception {
	super();
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		homepage=new HomePage();
		loginpage=new LoginPage();
		loginpage.login(obj.getProperty("username"),obj.getProperty("password"));
		
	}
	
	@Test
	public void verifyHomepageTitle()
	{
		String title = homepage.homePageTitle();
		String expectedTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		
		Assert.assertEquals(title,expectedTitle);
	}
	
	@Test
	public void searchItem() throws Exception
	{
		itempage=homepage.search(obj.getProperty("searchkey"));
	}
	
	@Test
	public void testMyname() throws Exception
	{
		
		String name=homepage.verifyName();
		Assert.assertEquals(name,obj.getProperty("Myname"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
