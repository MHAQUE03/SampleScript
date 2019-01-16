package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wordpress.utils.ReadValues;

public class LoginPage 

{
	WebDriver driver;
	ReadValues readvalues = new ReadValues("./src/test/resources/object.properties");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	public void setUserName(String userName)
	{
		String locatorValue = readvalues.getPropertyValue("LoginPage_setUserName_text_id");
		WebElement EnterUserName = driver.findElement(By.id(locatorValue));
		EnterUserName.clear();
		EnterUserName.sendKeys(userName);
	}

	
	public void setPassword(String password)
	{
		String locatorValue = readvalues.getPropertyValue("LoginPage_setPassword_text_id");
		WebElement EnterPassword = driver.findElement(By.id(locatorValue));
		EnterPassword.clear();
		EnterPassword.sendKeys(password);
	}

	
	public void clickOnLoginButton()
	{
		String locatorValue = readvalues.getPropertyValue("LoginPage_clickOnLoginButton_xpath");
		WebElement LoginButton = driver.findElement(By.xpath(locatorValue));
		LoginButton.click();
	}

	public void clickonContinueButton()
	{
		String locatorValue = readvalues.getPropertyValue("LoginPage_ContinueButton_xpath");
		WebElement ContinueButton = driver.findElement(By.xpath(locatorValue));
		ContinueButton.click();
	}
	
}
