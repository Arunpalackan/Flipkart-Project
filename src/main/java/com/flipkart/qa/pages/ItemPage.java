package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class ItemPage extends  TestBase{

	public ItemPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class='_396cs4 _3exPp9' and @alt='APPLE iPhone 11 Pro Max (Gold, 64 GB)']")
	WebElement iPhone;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
	WebElement BuyNow;
	
	public String getItemPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public void selectIphone()
	{
		iPhone.click();
		
	}
	
	
	public void buyNow()
	{
		BuyNow.click();
	}	

	
}
