package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actionDriver.Action;
import basepackage.Base;
import dataProviderPackage.DataFactory;
import pageObjects.HomePagePageObject;
import pageObjects.MyAccountPageObjects;
import utility.Log;
@Guice
public class SignInAccountTC extends Base{
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})	
	public void setup(String browser) {
		launchApp(browser);
	}

@Test(groups = "Sanity",dataProvider = "Credentials", dataProviderClass = DataFactory.class)
public void verifyHomePage(String username,String pwd) {
	HomePagePageObject homepageobject = new HomePagePageObject();
	homepageobject.isPageDisplayed();
	Log.info("Home page is displayed");
	Action.implicitWait(getDriver(), 10);
	homepageobject.performclick("signin");
	Log.info("clicked sign in button successfully");
	System.out.println(username);
	System.out.println(pwd);
	MyAccountPageObjects myaccountpageobject = new MyAccountPageObjects();
	myaccountpageobject.isPageDisplayed();
	myaccountpageobject.enterDetails("email", username);
	myaccountpageobject.enterDetails("password", pwd);
}

@AfterMethod(groups = {"Smoke","Sanity","Regression"})
public void tearDown() {
	//getDriver().quit();	
}
}
