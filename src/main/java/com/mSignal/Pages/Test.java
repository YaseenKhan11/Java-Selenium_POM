package com.mSignal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {
	
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		
	    String baseURL = "https://demo.guru99.com/test/newtours/register.php";
	    WebDriver driver;
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseURL);

		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("CANADA");

		//Selecting Items in a Multiple SELECT elements
		driver.get("http://jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("canada");
		fruits.selectByIndex(1);
		Thread.sleep(4000);
		driver.close();
	}
}
