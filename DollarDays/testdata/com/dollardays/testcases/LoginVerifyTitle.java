package com.dollardays.testcases;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import com.dollardays.pages.LoginPage;

public class LoginVerifyTitle extends BaseTest {
  @Test
  public void Login() {
	  LoginPage lpage=new LoginPage(driver);
		String expectedTitle = "DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle," Successfully Logged into the HomePage");
	 
  }
  
  
}

