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

public class Wordpresslogintest {
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
		driver.manage().window().maximize();
		
		hPage = new HomePage(driver);
		lPage = new LoginPage(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void testLoginwithInvalidCredentials_01() throws InterruptedException
	{
		
		hPage.clickOnLoginLink();		
		lPage.setUserName("Najla");		
		lPage.clickonContinueButton();		
		lPage.setPassword("Najla");		
		lPage.clickOnLoginButton();
		
		//String expected = "<span><svg class=\"gridicon gridicons-notice-outline\" height=\"24\" width=\"24\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\"><g><path d=\"M12 4c4.41 0 8 3.59 8 8s-3.59 8-8 8-8-3.59-8-8 3.59-8 8-8m0-2C6.477 2 2 6.477 2 12s4.477 10 10 10 10-4.477 10-10S17.523 2 12 2zm1 13h-2v2h2v-2zm-2-2h2l.5-6h-3l.5 6z\"></path></g></svg> Oops, that's not the right password. Please try again!</span>";
		//driver.getPageSource();// the page source is available for the user to see
		//String pageSource = driver.getPageSource();// set the variable as a string
		//AssertJUnit.assertTrue(pageSource.contains(expected));

		
		Thread.sleep(5000);
		String actualString = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in to your account.'])[1]/following::span[1]")).getText();
		Assert.assertTrue(actualString.contains("Oops, that's not the right password. Please try again!"));
		
		//src = driver.page_source;
		//text_found = re.search('text_to_search', src);
		//self.assertNotEqual(text_found, None);

	}
	@Test
	public void testLoginwithNumbers() throws InterruptedException
	{
		
		hPage.clickOnLoginLink();
		lPage.setUserName("23245");
		lPage.clickonContinueButton();
		lPage.setPassword("56421");
		lPage.clickOnLoginButton();
		
		Thread.sleep(5000);
		
		//String expected = "<span><svg class=\"gridicon gridicons-notice-outline\" height=\"24\" width=\"24\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\"><g><path d=\"M12 4c4.41 0 8 3.59 8 8s-3.59 8-8 8-8-3.59-8-8 3.59-8 8-8m0-2C6.477 2 2 6.477 2 12s4.477 10 10 10 10-4.477 10-10S17.523 2 12 2zm1 13h-2v2h2v-2zm-2-2h2l.5-6h-3l.5 6z\"></path></g></svg> 404 status code for \"GET /users/@#$%/auth-options\"</span>";
		//driver.getPageSource();// the page source is available for the user to see
		//String pageSource = driver.getPageSource();// set the variable as a string
		//AssertJUnit.assertTrue(pageSource.contains(expected));
		
		
		
		
		String actualString = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in to your account.'])[1]/following::span[1]")).getText();
		Assert.assertTrue(actualString.contains("We don't seem to have an account with that name. Double-check the spelling and try again!"));
		
		
	
	
	}
	@Test
	public void testLoginwith_splChr() throws InterruptedException
	{
		hPage.clickOnLoginLink();
		lPage.setUserName("#$%^^&");
		lPage.clickonContinueButton();
		
		Thread.sleep(5000);
		
		String actualString = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email Address or Username'])[1]/following::span[1]")).getText();
		Assert.assertTrue(actualString.contains("404 status code for \"GET /users/#$%^/auth-options\""));
		
		//button[text()='Log In']
		
		//String expected = "<span><svg class=\"gridicon gridicons-notice-outline\" height=\"24\" width=\"24\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\"><g><path d=\"M12 4c4.41 0 8 3.59 8 8s-3.59 8-8 8-8-3.59-8-8 3.59-8 8-8m0-2C6.477 2 2 6.477 2 12s4.477 10 10 10 10-4.477 10-10S17.523 2 12 2zm1 13h-2v2h2v-2zm-2-2h2l.5-6h-3l.5 6z\"></path></g></svg> 404 status code for \"GET /users/@#$%/auth-options\"</span>";
		//driver.getPageSource();// the page source is available for the user to see
		//String pageSource = driver.getPageSource();// set the variable as a string
		//AssertJUnit.assertTrue(pageSource.contains(expected));
		
			}
		
		
	}	
