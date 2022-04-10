package testCases;

import java.util.HashMap;

import org.bouncycastle.crypto.tls.DTLSTransport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actionDriver.Action;
import basepackage.Base;
import dataProviderPackage.DataFactory;
import pageObjects.CreateAccountPageObjects;
import pageObjects.HomePagePageObject;
import pageObjects.MyAccountPageObjects;
import utility.Log;

@Guice
public class CreateAccountTC extends Base{
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		//getDriver().quit();	
	}
	@Test(groups = "Sanity",dataProvider="CreateAccount", dataProviderClass = DataFactory.class)
	public void verifyCreateMyAccount(String email) {
		HomePagePageObject homepageobject = new HomePagePageObject();
		homepageobject.isPageDisplayed();
		Log.info("Home page is displayed");
		homepageobject.performclick("signin");
		Log.info("clicked sign in button successfully");
		MyAccountPageObjects myaccountpageobject = new MyAccountPageObjects();
		myaccountpageobject.isPageDisplayed();
		myaccountpageobject.enterDetails("create email", email);
		//myaccountpageobject.performclick("create an account");
		
	}
	@Test(groups = "Smoke",dataProvider = "AccountCreationData", dataProviderClass = DataFactory.class)
	public void verifyCreateAccount(HashMap<String,String> hashMapValue) {
		HomePagePageObject homepageobject = new HomePagePageObject();
		homepageobject.isPageDisplayed();
		Log.info("Home page is displayed");
		homepageobject.performclick("signin");
		Log.info("clicked sign in button successfully");
		MyAccountPageObjects myaccountpageobject = new MyAccountPageObjects();
		myaccountpageobject.isPageDisplayed();
		myaccountpageobject.enterDetails("create email",hashMapValue.get("Email"));
		myaccountpageobject.performclick("create an account");
		Action.implicitWait(getDriver(), 10);
		CreateAccountPageObjects createaccountpage = new CreateAccountPageObjects();
		createaccountpage.performclick("mr");
		createaccountpage.enterDetails("First name", hashMapValue.get("FirstName"));
		createaccountpage.enterDetails("Last Name", hashMapValue.get("LastName"));
		createaccountpage.enterDetails(" password", hashMapValue.get("SetPassword"));
		createaccountpage.enterDetails("Days", hashMapValue.get("Day"));
		createaccountpage.enterDetails("Months", hashMapValue.get("Month"));
		createaccountpage.enterDetails("Years", hashMapValue.get("Year"));
		createaccountpage.enterDetails("Address",hashMapValue.get("Address"));
		createaccountpage.enterDetails("city", hashMapValue.get("City"));
		createaccountpage.enterDetails("State", hashMapValue.get("State"));
		createaccountpage.enterDetails("Zipcode", hashMapValue.get("Zipcode"));
		createaccountpage.enterDetails("mobile phone", hashMapValue.get("MobilePhone"));
		createaccountpage.enterDetails("alias", "friends");
		//createaccountpage.performclick("register");
		
	}
	

}
