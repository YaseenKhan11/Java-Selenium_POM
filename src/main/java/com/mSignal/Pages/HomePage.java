package com.mSignal.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mSignal.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//H3[contains(text(),'Home')]")
	WebElement homeText;

	@FindBy(xpath = "//p[contains(text(),'Signal Admin')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//li[@class='sc-ewnqHT kAQDdO']")
	WebElement panelHomeLink;

	@FindBy(xpath = "//a[@href='/projects']/child::li")
	WebElement panelProjectsLink;

	@FindBy(xpath = "//a[@href='/projects']//following::li[1]")
	WebElement panelSignalsLink;

//initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyLoggedUser() {
		return userNameLabel.isDisplayed();
	}
		
	public ProjectListPage clickOnPanelProjectLink() {	// Need clarity??
		panelProjectsLink.click();
		return new ProjectListPage();
	}
	
	public HomePage clickOnPanelHomeLink() {
		panelHomeLink.click();
		return new HomePage();
	}
	
	public SignalsPage clickOnPanelSignalLink() {
		panelSignalsLink.click();
		return new SignalsPage();
	}
	
	
	
	
}
