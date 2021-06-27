package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class PaymentPage extends TestBase{

	public PaymentPage() throws Exception {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")
	WebElement Continue;
	
	@FindBy(xpath="//button[contains(text(),'Accept & Continue')]")
	WebElement Accept;
	
	public String checkPaymentPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public void confirmOrder()
	{
		Continue.click();
	}
	
	
	public void acceptTermsAndConditions()
	{
		Accept.click();
	}
	
	
	

}
