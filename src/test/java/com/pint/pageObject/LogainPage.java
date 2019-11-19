package com.pint.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogainPage { 
	WebDriver ldriver;

	public LogainPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement Txtusername;
	@FindBy(name = "password")
	@CacheLookup
	WebElement Txtpassword;
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement login;

	public void setUserName(String username) {
		Txtusername.sendKeys(username);
	}

	public void setPassowrd(String password) {
		Txtpassword.sendKeys(password);
	}

	public void clickOnLogin() {
		login.click();
	}
}
