package com.mSignal.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mSignal.Pages.HomePage;
import com.mSignal.Pages.LoginPage;
import com.mSignal.Pages.ProjectListPage;
import com.mSignal.base.TestBase;

public class HomePageTest extends TestBase {

	LoginPage loginPage; // Throughout the program will use as objected created for this class
	HomePage homepage; // need clarity?
	ProjectListPage projectListPage;
	public HomePageTest() {
		super(); // to initialize the ‘TestBase’ class for Constructor (Properties()). This will
					// call Super class constructor // creating Super class constructor
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		// LoginPage loginPage = new LoginPage();
		loginPage = new LoginPage(); // Objected created
		projectListPage = new ProjectListPage();
		
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test (priority = 1)
	public void verifyHomePageTitleTest() {
		String HomePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "DF mSignal AI", "Home page title not matched"); // When it fails, this will display "Login page title not matching" in the report
	}
	
	@Test (priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homepage.verifyLoggedUser());
	}
	
	@Test (priority = 3)
	public void VerifyProjectLinkTest() {
		projectListPage = homepage.clickOnPanelProjectLink();
	}
	
	// Action Class
//	public void ActionClassEx() {
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactLink.click();
//	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
