package com.flipkart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties obj;
	
	
	public TestBase() throws Exception
	{
		File src=new File("C:\\Users\\Arun Palackan\\eclipse-workspace\\FlipkartProject\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
		obj=new Properties();;
		FileInputStream objfile=new FileInputStream(src);
		obj.load(objfile);
	}
	
	
	public static void initialization()
	{
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Arun Palackan\\Desktop\\sel\\chromedriver.exe");
		driver = new ChromeDriver();		
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(obj.getProperty("url"));
		
	}
	public WebDriver getDriver() {
		
		return driver;
	}
	

}
