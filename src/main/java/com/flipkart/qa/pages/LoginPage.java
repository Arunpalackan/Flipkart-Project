package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	
	public LoginPage() throws Exception
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	WebElement username;
	
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement loginBtn;
	
	
	public HomePage login(String un,String pwd) throws Exception 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}

}
