package com.pint.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pint.pageObject.AddCustomerPage;
import com.pint.pageObject.LogainPage;

import junit.framework.Assert;


public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LogainPage lp = new LogainPage(driver);
		lp.setUserName(userName);
		logger.info("User name is provided");
		lp.setPassowrd(passWord);
		logger.info("Passsword is provided");
		lp.clickOnLogin();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		logger.info("providing customer details....");

		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		Thread.sleep(5000);
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		addcust.custemailid( randomestring() + "@gmail.com");
		addcust.custpassword("abcdef");
		Thread.sleep(5000);
		addcust.custsubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

}