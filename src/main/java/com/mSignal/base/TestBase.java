package com.mSignal.base;
/*
 * Yaseen Khan
 * Testing Git
 * Adding code to make the changes
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.mSignal.util.TestUtil;
import com.mSignal.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

//import com.crm.qa.util.TestUtil;
//import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
//	public  static EventFiringWebDriver e_driver;
//	public static WebEventListener eventListener;
	
// *Creating Constructor and Importing/calling Config.properties files inside TestBase class to read the properties
// *Reading the properties and intializing the Prop variable and prop can be used thoughout the program.
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/Admin/eclipse-workspace/mSignal_UI_Automation"
					+ "/src/main/java/com/mSignal/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
// *initialization method 
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Chrome")){
			//System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/Mapple/Java_Selenium/Drivers/chromedriver.exe");	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			//System.setProperty("webdriver.gecko.driver", "C:/Users/Admin/Desktop/Mapple/Java_Selenium/Drivers/geckodriver.exe");	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		
		// to generate the Logs in good manner
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
}
