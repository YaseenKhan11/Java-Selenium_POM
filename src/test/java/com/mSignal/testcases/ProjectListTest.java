package com.mSignal.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mSignal.Pages.CreateProjectPage;
import com.mSignal.Pages.HomePage;
import com.mSignal.Pages.LoginPage;
import com.mSignal.Pages.ProjectListPage;
import com.mSignal.base.TestBase;
import com.mSignal.util.TestUtil;

import com.mSignal.Analyzer.RetryAnalyzer;

public class ProjectListTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
	ProjectListPage projectListPage;
	CreateProjectPage createProjectPage;
	TestUtil testUtil;

	String sheetName = "CreateProject";
	Logger log = Logger.getLogger(ProjectListTest.class);

	public ProjectListTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage(); // Objected created
		projectListPage = new ProjectListPage();
		createProjectPage = new CreateProjectPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		projectListPage = homepage.clickOnPanelProjectLink();
		log.info("Successful with Initialization step");

	}

	// @Test(retryAnalyzer = com.mSignal.Analyzer.RetryAnalyzer.class)

	@Test(priority = 1)
	public void verifyProjectPageTab() {
		Assert.assertTrue(projectListPage.verifyProjectListTab(), "ProjectList tab missing on the page");
	}

	@Test(priority = 2)
	public void VerifyProjectID() {
		projectListPage.SelectProject();

	}

	@Test(priority = 3)
	public void verifyCreateProjectBtnClick() {
		projectListPage.clickOnCreateProjectBtn();
		createProjectPage.newProjectsTextDisplay();
		createProjectPage.selectDrugDP();
		createProjectPage.selectEventInput();
		createProjectPage.SelectMeddraInput();
		createProjectPage.selectStartDateField();
		createProjectPage.DisproportionalityAnalysis();
		createProjectPage.PrioritizationThreshold();
		createProjectPage.clickOnCreateBtn();
		projectListPage.ProductNamedisplayed();
		projectListPage.EventNamedisplayed();
		log.info("********** Successfully Create the New Project *************");

//		log.info("Entering Application URL");
//		log.warn("This is just a warning message");
//		log.fatal("This is just a fatal error message");
//		log.debug("this is just debug message");
	}

//	@DataProvider
//	public Object[][] getmSignalTestData() {
//		Object data[][] = testUtil.getTestData(sheetName);
//		return data;
//	}

//	@Test (priority = 4, dataProvider = "getmSignalTestData")
//	public void updateFieldsOnCreateProject(String drugs, String events, String ss) {
//		projectListPage.clickOnCreateProjectBtn();
//		//createProjectPage.newProjectsText();
//		//createProjectPage.verifySelectEvent();
//		//createProjectPage.selectDomainDP();
//		createProjectPage.verifyUpdateDrugEvent(drugs, events, ss);
//	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		log.info("Successfully LoggedOut");
	}
}
