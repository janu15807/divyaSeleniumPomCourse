package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BasePage {
		public WebDriver driver;
		public Properties prop;
		
		public WebDriver init_driver()
		{
			String browserName = prop.getProperty("browser");
			
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
				if(prop.getProperty("headless").equals("yes"))
				{
					ChromeOptions co = new ChromeOptions();
					co.addArguments("--headless");
					driver = new ChromeDriver(co);
				}else {
				          driver = new ChromeDriver();
				      }
			} else if (browserName.equals("firfox")){
				System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
				if(prop.getProperty("headless").equals("yes"))
				{
					FirefoxBinary fb = new FirefoxBinary();
					fb.addCommandLineOptions("--headless");
					FirefoxOptions fo = new FirefoxOptions();
					fo.setBinary(fb);
					driver = new FirefoxDriver(fo);
					
				}else {
				         driver = new FirefoxDriver();
				    }
			}else {
				System.out.println(browserName + " :is not correct or available");
				try {
					throw new Exception("NO BROWSERFOUND EXPECTION");
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
		    	driver.manage().window().fullscreen();
			    driver.manage().deleteAllCookies();
			    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			   return driver;
			
		}
		
		public Properties init_properties()
		{
			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("D:\\Divya\\Workspace\\divya_workspace\\divyaSeleniumPomCourse\\src\\main\\java\\com\\qa\\hubspot\\config\\config.prperties");
				prop.load(ip);
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			return prop;
		}

}
