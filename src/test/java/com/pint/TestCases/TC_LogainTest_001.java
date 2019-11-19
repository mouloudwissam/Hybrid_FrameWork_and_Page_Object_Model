package com.pint.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pint.pageObject.LogainPage;

import junit.framework.Assert;

public class TC_LogainTest_001 extends BaseClass {
	@Test
	public void logainTest() throws IOException {
		logger.info("URL is open");

		LogainPage lp = new LogainPage(driver);

		lp.setUserName(userName);

		logger.info("Enter User Name ");
		lp.setPassowrd(passWord);
		logger.info("Enter The Password");
		lp.clickOnLogin();
		if (driver.getTitle().equals("Guru99 Bank Home Page")) {
			Assert.assertTrue(true);
			logger.info("The Test Passed");
		} else {
			captureScreen(driver, "logainTest"); // for test case failed
			Assert.assertTrue(false);
			logger.info("The Test Failed"); 
			
		}
	}
}
