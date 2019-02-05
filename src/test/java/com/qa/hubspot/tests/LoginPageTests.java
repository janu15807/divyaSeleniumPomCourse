package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPages;

public class LoginPageTests {
	 
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPages loginPages;
	
	@BeforeMethod()
	public void setUp()
	{
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver();
		
		loginPages = new LoginPages(driver);
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test()
	public void verifyLoginTitlePage()
	{
		String title = loginPages.getLoginPageTitle();
		System.out.println("Login page title is "+ title);
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	@Test()
	public void verifyForgotPwdLinkTest()
	{
		Assert.assertTrue(loginPages.verifyForgotPasswordLink(), "forgot pwd link is not displayed");
	}
	
	@Test
	public void login_correctData_Test()
	{
		loginPages.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}
