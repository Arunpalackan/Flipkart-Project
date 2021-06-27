package com.flipkart.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.FinalPayementPage;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.ItemPage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.PaymentPage;
import com.flipkart.qa.util.TestUtil;

public class FInalPaymentPageTest extends TestBase{

	public FInalPaymentPageTest() throws Exception {
		super();
	}
	
	PaymentPage paymentpage;
	ItemPage itempage;
	HomePage homepage;
	LoginPage loginpage;
	TestUtil util;
	FinalPayementPage finalpage;
	Logger log=Logger.getLogger(LoginPageTest.class);
	
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		itempage=new ItemPage();
		paymentpage=new PaymentPage();
		finalpage=new FinalPayementPage();
		util=new TestUtil();
		homepage=new HomePage();
		loginpage=new LoginPage();
		loginpage.login(obj.getProperty("username"),obj.getProperty("password"));
		Thread.sleep(3000);
		homepage.search(obj.getProperty("searchkey"));
		itempage.selectIphone();
		util.navigateToNextTab();
		itempage.buyNow();
		Thread.sleep(2000);
		paymentpage.confirmOrder();
		Thread.sleep(2000);
		paymentpage.acceptTermsAndConditions();

		
	}
	
	@Test
	public void enterCardDetails() throws Exception
	{
		finalpage.selectRadioBtnCredit();
		finalpage.enterCardNumber();
		finalpage.selectMonth();
		finalpage.selectYear();
		finalpage.enterCvv();
		Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);
		boolean ispresent=finalpage.validityCheck();
		if(ispresent)
		{
			log.info("Wrong Credit Card Number");
		}
		else
		{
			log.error("Credit card number succesfull");
		}
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
