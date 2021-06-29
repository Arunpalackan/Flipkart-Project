package com.flipkart.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.ItemPage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.util.TestUtil;

public class itemPagetest extends TestBase{

	public itemPagetest() throws Exception {
		super();
	}
	
	ItemPage itempage;
	HomePage homepage;
	LoginPage loginpage;
	TestUtil util;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		itempage=new ItemPage();
		util=new TestUtil();
		homepage=new HomePage();
		loginpage=new LoginPage();
		loginpage.login(obj.getProperty("username"),obj.getProperty("password"));
		homepage.search(obj.getProperty("searchkey"));
		

	}
	@Test
	public void itemPageTitleCheck()
	{
		String actual = itempage.getItemPageTitle();
		String expected="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals( expected, actual);
	}
	
	@Test(description="selected Iphone")
	public void selectIphone()
	{
		itempage.selectIphone();
	}
	
	
	@Test(description="clicked buynow button")
	public void BuyNow() 
	{
		itempage.selectIphone();
		util.navigateToNextTab();
		itempage.buyNow();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
