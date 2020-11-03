package com.dollardays.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;
import com.dollardays.pages.HomePage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.net.HttpURLConnection;
import java.net.URL;

public class HomePageDisplay extends BaseTest{
	
	@DDDataProvider(datafile = "D:\\Ritu\\Testing Training\\Srikanth-Testing Training\\DollarDays Project\\DollarDaysAutomation\\Team2_TaxExempt-master\\testdata\\testdata.xlsx", sheetName = "Home",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	
    public void CheckDisplay(Hashtable<String, String> data) throws InterruptedException{
	
	  HomePage home = new HomePage(driver);
	  home.findbrokenlinks(); 		
	  home.HomePageDisplay();
	  home.LogoCheck();
	  Thread.sleep(1000);
	  System.out.println ("Logo verified");
	  home.getMenu().click();
	  Thread.sleep(2000);
	  home.getMenuClose().click();
	  Thread.sleep(1000);
	  System.out.println ("Menu being displayed");
	  home.getSearchBar();
	  Thread.sleep(2000);
	  System.out.println ("Search Bar being displayed");
	  home.verifyCallToday();
	  Thread.sleep(2000);
	  System.out.println ("Call Today being displayed");
	  home.verifySignIn().click();
	  Thread.sleep(2000);
	  System.out.println ("Sign In being displayed");
	  home.getDropdownSignIn();
	  Thread.sleep(1000);
	  home.getDropdownCreateAccount();
	  Thread.sleep(1000);
	  home.getDropdownHelp();
	  Thread.sleep(2000);
	  System.out.println ("Sign In menu items verified");
	  home.verifyWishList().click();
	  Thread.sleep(2000);
	  System.out.println ("Wish List being displayed");
	  home.verifyCart();
	  Thread.sleep(2000);
	  System.out.println ("Cart being displayed");
	  home.verifyWishList().click();
	  home.SignUpDealsEmail(data.get("UserName"));
	  
  }
	@DDDataProvider(datafile = "D:\\Ritu\\Testing Training\\Srikanth-Testing Training\\DollarDays Project\\DollarDaysAutomation\\Team2_TaxExempt-master\\testdata\\testdata.xlsx", sheetName = "Home",  testcaseID = "TC2", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void SignUpDealsInvalid (Hashtable<String, String> data) throws InterruptedException{
		HomePage home = new HomePage(driver);
		home.SignUpDealsEmail(data.get("UserName"));
		String Actual_msg = driver.switchTo().alert().getText();
		String Expected = "Invalid email. Please try again.";
		Thread.sleep(2000);
		// Verify error message
		Assert.assertEquals(Actual_msg, Expected);
		driver.switchTo().alert().accept();
	}
	
	@DDDataProvider(datafile = "D:\\Ritu\\Testing Training\\Srikanth-Testing Training\\DollarDays Project\\DollarDaysAutomation\\Team2_TaxExempt-master\\testdata\\testdata.xlsx", sheetName = "Home",  testcaseID = "TC3", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void SignUpDealsBlank (Hashtable<String, String> data) throws InterruptedException{
		HomePage home = new HomePage(driver);
		home.SignUpDealsEmail(data.get("UserName"));
		String Actual_msg = driver.switchTo().alert().getText();
		String Expected = "Please enter your email.";
		Thread.sleep(2000);
		// Verify error message
		Assert.assertEquals(Actual_msg, Expected);
		driver.switchTo().alert().accept();
	}
	

}

