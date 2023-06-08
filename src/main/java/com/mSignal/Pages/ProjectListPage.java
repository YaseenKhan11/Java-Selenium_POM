package com.mSignal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.hash.BloomFilter;
import com.mSignal.base.TestBase;

public class ProjectListPage extends TestBase {
	
	@FindBy(xpath = "//div[@class='ant-tabs-tab ant-tabs-tab-active']")
	WebElement projectListTab;
	
	@FindBy(xpath = "//span[text()='Create Project']")
	WebElement createProjectBtn;
	
	@FindBy(xpath = "//table//tbody/tr[1]/td[1]")
	WebElement SelectProjectInTable;

	// initializing the Page Objects
	public ProjectListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyProjectListTab() {
		return projectListTab.isDisplayed();
	}
	
	public CreateProjectPage clickOnCreateProjectBtn() {
		createProjectBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new CreateProjectPage();
		
	}
	
//	public boolean SelectDynamicXpath(String ProjectID) {
//		return driver.findElement(By.xpath("//p[text()='"+ProjectID+"']")).isDisplayed();
//	}

	
	public void SelectProject() {
		SelectProjectInTable.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
