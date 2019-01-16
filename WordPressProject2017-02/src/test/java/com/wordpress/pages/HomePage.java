package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wordpress.utils.ReadValues;

public class HomePage 

{
	WebDriver driver;
	ReadValues readvalues = new ReadValues("./src/test/resources/object.properties");
	
		public HomePage(WebDriver driver)
		{
			this.driver = driver;
		}

public void clickOnLoginLink()
{
	String locatorValue = readvalues.getPropertyValue("HomePage_loginlink_linktext");
	WebElement LoginClick = driver.findElement(By.linkText(locatorValue));
	LoginClick.click();
}
	
}
