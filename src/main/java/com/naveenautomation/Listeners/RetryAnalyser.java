package com.naveenautomation.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomation.TestBases.TestBase;

public class RetryAnalyser extends TestBase implements IRetryAnalyzer{
	int cnt = 0;

	int maxCnt = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (cnt < maxCnt) {
			logger.info("Test failed, Retrying for " + cnt + " ,Test Name : " + result.getMethod().getMethodName());
			cnt++;
			return true;
		}

		return false;
	}
}
