package com.mSignal.Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int counter = 0;
	int retrylimit = 3; // Change to num_3  // for Retry mode test run
	
	public boolean retry (ITestResult result) {
		if (counter < retrylimit) {
			counter++;
			return true;
		}
		return false;
	}
}