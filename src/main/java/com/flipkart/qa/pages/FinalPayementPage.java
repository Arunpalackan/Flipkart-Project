package com.flipkart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.util.TestUtil;

public class FinalPayementPage extends TestBase{

	public FinalPayementPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Credit / Debit / ATM Card')]")
	WebElement radiobtn;
	
	@FindBy(name="cardNumber")
	WebElement cardnumber;
	
	@FindBy(name="month")
	WebElement expmonth;
	
	@FindBy(name="year")
	WebElement expyear;
	
	@FindBy(name="cvv")
	WebElement cvv;
	
	@FindBy(xpath="//div[contains(text(),'Credit / Debit / ATM Card')]")
	WebElement creditCard;
	
	@FindBy(xpath="//span[contains(text(),'Not a valid card number')]")
	WebElement notValidcard;
	
	TestUtil util;
	
	public void selectRadioBtnCredit()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(creditCard);
		actions.build().perform();
		radiobtn.click();
	}
	public void enterCardNumber() throws Exception
	{
		cardnumber.sendKeys("416021082345");
	}
	public void selectMonth()
	{
		Select dropdown=new Select(expmonth);
		dropdown.selectByValue("04");  
	}
	public void selectYear()
	{
		Select dropdown=new Select(expyear);
		dropdown.selectByValue("31");  
	}
	public void enterCvv()
	{
		cvv.sendKeys("123");
	}
	public boolean validityCheck()
	{
		//driver.findElements(By.xpath("//span[contains(text(),'Not a valid card number')]").
		boolean validity =driver.findElements(By.xpath("//span[contains(text(),'Not a valid card number')]")).size() > 0;
		return validity;
		
	}

}
