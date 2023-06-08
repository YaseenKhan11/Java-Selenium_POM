package com.mSignal.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.mSignal.base.TestBase;

import freemarker.core.ReturnInstruction.Return;

public class LoginPage extends TestBase{
	
// Page factory / Object Repository (OR)
// Page factory : we have to use one annotation - @FindBy : hence no need of 'driver.findelement'
	
	@FindBy(xpath="//img[@alt='Client logo']")
	WebElement logo;
	
	@FindBy(xpath="//title[text()='DF mSignal AI']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[.//text() = 'Login']")
	WebElement loginBtn;
	
// Need to initialize the OR / elements with help of page factory.
// to initialize the OR am Creating the Constructor as below
	
//initializing the Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

 //Actions
 	public String ValidateLoginpageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatemSignalImage() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
