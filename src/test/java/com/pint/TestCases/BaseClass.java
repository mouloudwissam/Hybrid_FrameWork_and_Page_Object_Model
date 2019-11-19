package com.pint.TestCases;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.pint.Uilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseUrl = readconfig.getApplicationUrl();
	public String userName = readconfig.getUserName();
	public String passWord = readconfig.getPassWord();
	public String pathChrome = readconfig.getChromePath();
	public String pathopera = readconfig.getOpera();
	public String pathFirefox = readconfig.getFireFox();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", pathChrome);
			driver = new ChromeDriver();
		} else if (br.equals("opera")) {
			System.setProperty("webdriver.opera.driver", pathopera);
			driver = new OperaDriver();

		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", pathFirefox);
			driver = new FirefoxDriver();

		}

		logger = Logger.getLogger("peopleandtech");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
	}
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	public String randomestring1()
	{
		String generatedstring1=RandomStringUtils.randomNumeric(4);
		return(generatedstring1);
	}

}
