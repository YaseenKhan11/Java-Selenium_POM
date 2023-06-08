package com.mSignal.Pages;

import org.openqa.selenium.support.PageFactory;

import com.mSignal.base.TestBase;

public class SignalsPage extends TestBase{

	//initializing the Page Objects
		public SignalsPage() {
			PageFactory.initElements(driver, this);
		}
}
