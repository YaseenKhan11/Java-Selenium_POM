package com.mSignal.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mSignal.Pages.HomePage;
import com.mSignal.Pages.LoginPage;
import com.mSignal.base.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginPage; // Throughout the program will use as objected created for this class
	HomePage homepage;	// need clarity?
	
	public LoginPageTest() {	
		super(); 			// to initialize the ‘TestBase’ class for Constructor (Properties()). This will call Super class constructor // creating Super class constructor
	}

	@BeforeMethod
	public void setup() {
		initialization();
		//LoginPage loginPage = new LoginPage();
		loginPage = new LoginPage();		//	Objected created
	}
	
	@Test (priority = 1)
	public void loginPageTitleTest() {
		String LoginPageTitle = loginPage.ValidateLoginpageTitle();
			Assert.assertEquals(LoginPageTitle, "DF mSignal AI", "Login page title not matched");		
	}
	
	@Test (priority = 2)
	public void mSignalLogoImageTest () {
		boolean Flag = loginPage.validatemSignalImage();
		Assert.assertTrue(Flag);
	}
	
	@Test (priority = 3)
	public void LoginTest() {
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
