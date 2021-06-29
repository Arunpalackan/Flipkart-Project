package com.flipkart.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.ItemPage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.PaymentPage;
import com.flipkart.qa.util.TestUtil;

public class PaymentPageTest extends TestBase{

	public PaymentPageTest() throws Exception {
		super();
	}
	
	PaymentPage paymentpage;
	ItemPage itempage;
	HomePage homepage;
	LoginPage loginpage;
	TestUtil util;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		itempage=new ItemPage();
		paymentpage=new PaymentPage();
		util=new TestUtil();
		homepage=new HomePage();
		loginpage=new LoginPage();
		loginpage.login(obj.getProperty("username"),obj.getProperty("password"));
		Thread.sleep(2000);
		homepage.search(obj.getProperty("searchkey"));
		Thread.sleep(1000);
		itempage.selectIphone();
		util.navigateToNextTab();
		itempage.buyNow();
	}
	@Test
	public void verifyTitle()
	{
		String actual=paymentpage.checkPaymentPageTitle();
		String expected ="Apple iPhone 11 Pro Max ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com";
		Assert.assertEquals( expected, actual);
	}
	
	
	@Test 
	public void confirmOrder() {
		
		paymentpage.confirmOrder();
	}
	
	@Test
	public void AcceptTermsAndCondi() throws Exception
	{
		paymentpage.confirmOrder();
		Thread.sleep(2000);
		paymentpage.acceptTermsAndConditions();
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
