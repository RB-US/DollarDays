package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.ExampleSearch;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
import org.openqa.selenium.support.FindBy;

public class ExampleSearchTestcase extends BaseTest{
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void search(Hashtable<String, String> hash) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		System.out.println(hash.get("TestCase"));
		ExtentTestManager.startTest("Testing of DollarDay site for Search");
		ExtentTestManager.getTest().log(Status.PASS,
				"Testcase: " + (hash.get("TCID")) + "-----" + (hash.get("TestCase")));
		LoginPage lpage=new LoginPage(driver);
		lpage.login(hash.get("UserName"), Base64.decrypt(hash.get("Password")));
		System.out.println("GOT THE CREDENTIALS");
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Login with Valid credentials");
		//ExtentTestManager.getTest().log(Status.INFO, "Test case 1: enter login");//INFO,pASS,
		
		//ExampleSearch ex= new ExampleSearch(driver);
		//ex.search();
		//ExtentTestManager.getTest().log(Status.INFO, "Ste 1: search backack");//INFO,pASS,
         SearchPage searchpage = new SearchPage(driver);
		
		searchpage.getSearchBar().sendKeys("backpack");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Search for Backpack");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3: clicked on the search button");
		Thread.sleep(500);
		
		String categoryCount = searchpage.getsearchCount().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4: Should display '"+categoryCount+"'");
		
		Thread.sleep(500);
		
		searchpage.getfirstPageBtn();
		Thread.sleep(2000);
		
		searchpage.getFirstProduct().click();
		Thread.sleep(5000);
		
		
	}
}
