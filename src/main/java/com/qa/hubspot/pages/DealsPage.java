package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class DealsPage extends BasePage {

	@FindBy(xpath="//span[contains(text(),'Create deal')]")
	WebElement createDealTab;
	
	@FindBy(id="uid-ctrl-1")
	WebElement dealName;
	
	@FindBy(xpath="//*[@id=\"uid-ctrl-21\"]/span/span[1]")
	WebElement dealStage;
	
	@FindBy(id="uid-ctrl-4")
	WebElement amount;
	
	@FindBy(xpath="//button[@class='uiButton private-button private-button--default private-button--primary private-button--non-link']")
	WebElement createBtn;
	
	
	public DealsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewDeals(String dealname, String amountVal)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(createDealTab));
		createDealTab.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(dealName));
		dealName.sendKeys(dealname);
		
		wait.until(ExpectedConditions.elementToBeClickable(amount));
		amount.sendKeys(amountVal);
		
		wait.until(ExpectedConditions.elementToBeClickable(createBtn));
		createBtn.click();
		
		
	}
	
	
	
}
