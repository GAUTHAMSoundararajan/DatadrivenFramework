package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.Base;
import pageObjects.HomePagePageObject;
import pageObjects.MyAccountPageObjects;

public class CreateAccountTC extends Base{
	
@BeforeMethod	
public void setup() {
	launchApp();
}
@AfterMethod
public void tearDown() {
	getDriver().quit();	
}
@Test
public void verifyHomePage() {
	HomePagePageObject homepageobject = new HomePagePageObject();
	homepageobject.isPageDisplayed();
	homepageobject.performclick("signin");
	MyAccountPageObjects myaccountpageobject = new MyAccountPageObjects();
	myaccountpageobject.isPageDisplayed();
}
}
