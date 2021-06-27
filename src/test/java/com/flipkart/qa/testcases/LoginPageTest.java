package com.flipkart.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homePage;
	TestUtil util;
	 public LoginPageTest() throws Exception {
		super();
	}
	
	
	 
	@BeforeMethod
	public void setup() throws Exception
	{
		
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateTitle();
		String exTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(title, exTitle);	
	}
	
	@Test(priority=2)
	public void loginTest() throws Exception
	{
		util=new TestUtil();
		String m = util.setMapData().get("username");
		System.out.println(m);
		homePage= loginpage.login(m,obj.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
