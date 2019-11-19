package com.pint.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pint.Uilities.XLUtils;
import com.pint.pageObject.LogainPage;

import junit.framework.Assert;

public class TC_LogainDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void LogainTDD(String user, String pwd) throws InterruptedException {
		LogainPage lp = new LogainPage(driver);
		lp.setUserName(user);
		lp.setPassowrd(pwd);
		lp.clickOnLogin();
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warning("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickOnLogin();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/pint/TestData/Book11.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}
		return logindata;
	}
}
