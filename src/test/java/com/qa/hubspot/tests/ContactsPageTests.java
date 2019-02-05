package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPages;

public class ContactsPageTests {
   
	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPages loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	
	
	@BeforeMethod
	public void setUp()
	{
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPages(driver);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage(driver);
		contactsPage = homePage.clickContacts();
		
		
	}
	
	
	@Test
	public void createNewContacsTest()
	{
		contactsPage.createNewContact("naveenlkh.yahoo.com", "Mike",  "Brown",  "qa");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}


