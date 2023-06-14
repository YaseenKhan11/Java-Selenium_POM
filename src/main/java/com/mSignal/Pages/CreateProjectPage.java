package com.mSignal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mSignal.base.TestBase;

public class CreateProjectPage extends TestBase {

	@FindBy(xpath = "//span[text()='New Project']")
	WebElement newProjectText;

	@FindBy(xpath = "//input[@id='rc_select_0']")
	WebElement selectDomain;

	@FindBy(xpath = "//*[@id='drug']")
	WebElement SelectDrug;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	WebElement SelectDrugStepTwo;	

	@FindBy(xpath = "//input[@id='selectedevent']")
	WebElement SelectEvent;

	@FindBy(xpath = "//input[@id='meddra']")
	WebElement SelectMeddra;
	
	@FindBy(xpath = "//*[@id='timeperiod']/..")
	WebElement StartDate;
	
	@FindBy(xpath = "//input[@placeholder='Start date']")
	WebElement StartDateTwo;
	
	@FindBy(xpath = "//input[@id='timeperiod' and @placeholder='Start date']")
	WebElement StartDateThree;
	
	@FindBy(xpath = "//table/tbody/tr/td[@class='ant-picker-cell ant-picker-cell-in-view ant-picker-cell-range-start ant-picker-cell-range-start-single ant-picker-cell-selected']")
	WebElement StartDateHighlight;
	
	@FindBy(xpath = "//input[@placeholder='End date']")
	WebElement EndDate;
	
	@FindBy(xpath = "//div[@title='PT']")
	WebElement SelectMeddraStepTwo;	
	
	@FindBy(xpath = "//*[@id='statisticalmethods']")
	WebElement DisproportionalityAnalysisInput;
	
	@FindBy(xpath = "//div[text()='Proportional Reporting Ratio (PRR)' and @class='ant-select-item-option-content']")
	WebElement DisproportionalityAnalysisInputStepTwo;

	@FindBy(xpath="//*[@id='prioritizationthreshold']")
	WebElement PrioritizationThresholdInput;
	
	@FindBy(xpath="//*[text()='Create']/..")
	WebElement CreateBtn;
	
	@FindBy(xpath="//*[@id='timeperiod']/..")
	WebElement timeStartBtn;
	
	@FindBy(xpath="//input[@placeholder='End date']/..")
	WebElement timeEndBtn;
		
	
	// initializing the Page Objects
	public CreateProjectPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean newProjectsTextDisplay() {
		return newProjectText.isDisplayed();
	}
	
//	public void selectDomainDP() {
//		selectDomain.sendKeys("Drugs");
//		SelectDrugStepTwo.click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void selectDrugDP() {
		SelectDrug.sendKeys("OXYCODONE");
		SelectDrugStepTwo.click();
	}
	
	public void selectEventInput() {
		SelectEvent.sendKeys("Pain");
	}
	
	public void SelectMeddraInput() {
		SelectMeddra.sendKeys("PT");
		SelectMeddraStepTwo.click();		
	}
		
	public void selectStartDateField() {
		StartDate.click();
		StartDateTwo.sendKeys("08-Jun-2015");
		StartDateHighlight.click();
		EndDate.sendKeys("13-May-2023"); 
		EndDate.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DisproportionalityAnalysis() {
		DisproportionalityAnalysisInput.click();
		DisproportionalityAnalysisInputStepTwo.click();
	}
	
	public void PrioritizationThreshold() {
		PrioritizationThresholdInput.sendKeys("1");
	}
	
	public ProjectListPage clickOnCreateBtn() {
		CreateBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ProjectListPage();
	}
	
//	public void DateTime() {
//		
//	}
	
//	 public void verifySelectDomain(String value, String SD, String drg) { 
//		 Select select = new Select(selectDomain);
//	 select.selectByVisibleText(value);
//	 
//	 selectDomain.sendKeys("SD"); SelectDrug.sendKeys("CISPLATIN"); }
	 
	//public void verifySelectDomain
	

//	public void selectDomainDP() {
//		WebElement dropdown = selectDomain;
//		Select select = new Select(dropdown);
//		select.selectByVisibleText("Vaccines");
//	}

	public void verifyUpdateDrugEvent(String drugs, String events, String ss) { // 10min 4th video
		Select select = new Select(driver.findElement(By.id("")));
		select.selectByVisibleText(drugs);
		SelectEvent.sendKeys(events);
		SelectMeddra.sendKeys(ss);
	}
}
