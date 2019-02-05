package com.qa.hubspot.tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPages;





public class HomePageTests {
	
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPages loginpage;
	public HomePage homePage;
		
	@BeforeMethod
	public void setUp()
	{
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver();
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPages(driver);
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test
	public void verifyHomePageTitleTest()
	{
		
		String title = homePage.getHomePageTitle();
		System.out.println("Homepage title is"+ title);
		Assert.assertEquals(title, "Reports dashboard");
	}
	
	@Test
	public void verifyHomePageHeaderTest()
	{
		Assert.assertTrue(homePage.getHomePageHeader());
	}
	
	@Test
	public void verifyHomePageUserIdTest()
	{
		String userid = homePage.homepageUserIdDisplay();
		System.out.println(userid);
		Assert.assertEquals(userid, "NaveenAutomationLabs");
		
	}
	
	@Test
	public void getContactsPageTest()
	{
		homePage.clickContacts();
	}
	
	@Test
	public void getDealsPageTest()
	{
		homePage.clickOnDeals();
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}



