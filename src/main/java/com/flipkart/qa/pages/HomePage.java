package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class HomePage extends TestBase{
	ItemPage itempage;
	
	public HomePage() throws Exception
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Arun')]")
	WebElement Myname;
	
	@FindBy(name="q")
	WebElement searchBar;
	
	
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyName()
	{
		return Myname.getText();
	}

	public ItemPage search(String item)
	{
		searchBar.sendKeys(item);
		searchBar.submit();
		return itempage;
	}
}
