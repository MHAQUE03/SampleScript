package com.wordpress.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.pages.HomePage;
import com.wordpress.pages.LoginPage;
import com.wordpress.utils.ExcelUtil;

public class WordpressExcel {
	WebDriver driver; 
	
	HomePage hPage;
	LoginPage lPage;
	


	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "C:/Users/Adnan/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://wordpress.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		hPage = new HomePage(driver);
		lPage = new LoginPage(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void testLoginwithInvalidCredentials_01()
	{
		ExcelUtil eUtil = new ExcelUtil("./src/test/resources/Login.xls",0);
		int count = eUtil.numberOfRows();
		
		for(int i=1;i<=count;i++)
		{	
		
		String userName = eUtil.getCellValue(i,0);
		String passWord = eUtil.getCellValue(i,1);
		String expectedOutput = eUtil.getCellValue(i,2);
		
		hPage.clickOnLoginLink();		
		lPage.setUserName(userName);		
		lPage.clickonContinueButton();		
		lPage.setPassword(passWord);		
		lPage.clickOnLoginButton();
		
		//String expected = "<span><svg class=\"gridicon gridicons-notice-outline\" height=\"24\" width=\"24\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\"><g><path d=\"M12 4c4.41 0 8 3.59 8 8s-3.59 8-8 8-8-3.59-8-8 3.59-8 8-8m0-2C6.477 2 2 6.477 2 12s4.477 10 10 10 10-4.477 10-10S17.523 2 12 2zm1 13h-2v2h2v-2zm-2-2h2l.5-6h-3l.5 6z\"></path></g></svg> Oops, that's not the right password. Please try again!</span>";
		//driver.getPageSource();// the page source is available for the user to see
		//String pageSource = driver.getPageSource();// set the variable as a string
		//AssertJUnit.assertTrue(pageSource.contains(expected));

		String actualString = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in to your account.'])[1]/following::span[1]")).getText();
		Assert.assertTrue(actualString.contains(expectedOutput));
		driver.get("https://wordpress.com/");
		
		//src = driver.page_source;
		//text_found = re.search('text_to_search', src);
		//self.assertNotEqual(text_found, None);
		
		}

	}
	
			
		
		
	}	
