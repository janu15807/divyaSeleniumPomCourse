package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;

public class LoginPages extends BasePage {
	
	//1. Page objects with the help of PageFactory
	@FindBy(id = "username")
	WebElement loginName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "loginBtn")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a/i18n-string[contains(text(),'Forgot my password')]")
	WebElement forgetPwdLink;
	
	//2.create a constructor of page class and initialize page elements
	 
	public LoginPages(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);  // instead of write loginPages(class name) we can give "this" also
		
	}
	
	//3. create methods/Actions of page:
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}	
	
	public boolean verifyForgotPasswordLink()
	{
		return forgetPwdLink.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		loginName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(driver);
		
	}

}
