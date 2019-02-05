package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspt.utill.Utill;


public class HomePage extends BasePage {
 
		@FindBy(xpath ="//h1[contains(text(),'Sales Dashboard')]")
		WebElement homePageHeader;
		
		@FindBy (xpath = "//span[@class='account-name ']")
		WebElement userId;
		
		@FindBy(xpath = "//li[@class='expandable ']/a[@id='nav-primary-contacts-branch']") ////li[@class='expandable ']/a[@id='nav-primary-contacts-branch']
		WebElement contactsTap;
		
		@FindBy(xpath = "//*[@id=\"nav-secondary-contacts\"]" )    // "//*[@id=\"nav-secondary-contacts\"]"
		WebElement contactsLink;
		
		@FindBy(xpath = "//li[@class='expandable ']//a[contains(text(),'Sales')]")
		WebElement sales;
		
		@FindBy(xpath="//*[@id=\"nav-secondary-deals\"]")
		WebElement deals;
		
		
		
		public HomePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public String getHomePageTitle()
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.titleContains("Reports dashboard"));
			
			return driver.getTitle();
		}
		
		
		public boolean getHomePageHeader()
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(homePageHeader));

			return homePageHeader.isDisplayed();
		}
		
		public String homepageUserIdDisplay()
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(userId));
			
			userId.isDisplayed();
			
			return userId.getText();
		}
		
		public ContactsPage clickContacts() 
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(contactsTap));
			contactsTap.click();
			Utill.mediumTime();
			contactsLink.click();
			    
			    return new ContactsPage(driver);
			
			
		}
		
		public DealsPage clickOnDeals()
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(sales));
			sales.click();
			Utill.shortTime();
			deals.click();
			
			return new DealsPage(driver);
		}
		
}

