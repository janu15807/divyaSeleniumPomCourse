package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.DealsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPages;

public class DealsPageTests {
	
	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPages loginPage;
	public HomePage homePage;
	public DealsPage dealsPage;
	
	
	
	@BeforeMethod
	public void setUp()
	{
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPages(driver);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//homePage = new HomePage(driver);
		dealsPage = homePage.clickOnDeals();
		
		
	}
	
	@Test
	public void createNewDealsTest()
	{
		dealsPage.createNewDeals("diamond", "5000");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
}
