package com.dollardays.pages;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dollardays.commons.Base64;
import org.openqa.selenium.interactions.Actions;
import java.net.HttpURLConnection;
import java.net.URL;


public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void HomePageDisplay () throws InterruptedException {
		String expectedTitle = "DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, " Successfully Logged into the HomePage");
		System.out.println("Home page getting displayed: Title verified");
	}
	
	@FindBy(xpath="/html/body/form/header/div/div/div/div[1]/div/div[4]/figure/div/a/img")
	private WebElement Logo;
	
	public WebElement LogoCheck () throws InterruptedException {
		return Logo;
	}
	
	//Home Page Locators
	
	//Menu
	@FindBy(xpath = "//*[@id=\"sm_menu_ham\"]")
	private WebElement Menu;

	public WebElement getMenu() {
		return Menu;
	}
	
	//Menu Close
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[1]/div/div[1]/div/i/img")
	private WebElement MenuClose;

	public WebElement getMenuClose() {
		return MenuClose;
	}
	//Search Bar
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[2]/div[1]/div[1]/input")
	public WebElement searchbar;

	public WebElement getSearchBar() {
		return searchbar;
	}
	
	//Call Today
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[1]/div/span/strong")
	private WebElement CallToday;

	public WebElement verifyCallToday() {
		return CallToday;
	}
	
	//Sign In
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/a/img")
	private WebElement SignIn;

	public WebElement verifySignIn() {
		return SignIn;
	}
	
	//Sign In Menu Elements
	
	//Sign In
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/ul/li[2]/a")
	private WebElement dropdownSignIn;
	
	//CreateAccount
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/ul/li[3]/a")
	private WebElement CreateAccount;
	
	//Help
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/ul/li[4]/a")
	private WebElement Help;

	public WebElement getDropdownSignIn() {
		return dropdownSignIn;
		
	}
	
	public WebElement getDropdownCreateAccount() {
		return CreateAccount;
		
	}
	
	public WebElement getDropdownHelp() {
		return Help;
		
	}
	
	//WishList
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[2]/a/span")
	private WebElement WishList;

	public WebElement verifyWishList() {
		return WishList;
	}
	
	//Cart
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[3]/div/a/img")
	private WebElement Cart;

	public WebElement verifyCart() {
		return Cart;
	}
	
	
	//Sign Up Exclusive Deals
	@FindBy(xpath = "/html/body/form/footer/div[1]/div/div/div[2]/div/div[2]/div/div[1]/input")
	private WebElement SignUpDeals;

	public WebElement SignUpDeals() {
		return SignUpDeals;
	}
	
	//Sign Up Exclusive Deals-Submit
		@FindBy(xpath = "//*[@id=\"btnAcceptOffer\"]")
		private WebElement SignUpDealsSubmit;

		public WebElement SignUpDealsSubmit() {
			return SignUpDealsSubmit;
	
}
		public void SignUpDealsEmail(String username) throws InterruptedException {
			Actions actions = new Actions(driver);
			actions.moveToElement(SignUpDeals);
			actions.perform();
			SignUpDeals.sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(5000);
			SignUpDeals.sendKeys(username);
			
			//SignUpDeals.click();
			Thread.sleep(1000);
			SignUpDealsSubmit.click();
		}
		
		public void findbrokenlinks () {
		List<WebElement> links = driver.findElements(By.tagName("a"));
	
		System.out.println("Total links are "+links.size());
        //used for loop to
		for(int i=0; i<links.size(); i++) {
		WebElement element = links.get(i);
		//By using "href" attribute, we could get the url of the required link
		String url=element.getAttribute("href");
		//calling verifyLink() method here. Passing the parameter as url which we collected in the above link
		//See the detailed functionality of the verifyLink(url) method below
		verifyLink(url);
		}	
	    System.out.println("All links are working");
		}
		
		// The below function verifyLink(String urlLink) verifies any broken links and return the server status.
				public static void verifyLink(String urlLink) {
				        //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
				        try {
				//Use URL Class - Create object of the URL Class and pass the urlLink as parameter
				URL link = new URL(urlLink);
				// Create a connection using URL object (i.e., link)
				HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
				//Set the timeout for 2 seconds
				httpConn.setConnectTimeout(2000);
				//connect using connect method
				httpConn.connect();
				//use getResponseCode() to get the response code.
				if(httpConn.getResponseCode()== 200) {
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
				}
				if(httpConn.getResponseCode()== 404) {
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
				}
				}
				//getResponseCode method returns = IOException - if an error occurred connecting to the server.
				catch (Exception e) {
				//e.printStackTrace();
				}
		
}
}
