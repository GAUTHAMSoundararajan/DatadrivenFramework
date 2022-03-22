package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class HomePagePageObject extends Base {
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signinButton;
	@FindBy(xpath = "//a[contains(text(),'Contact us')]")
	WebElement contactusButton;
	
	
	public HomePagePageObject() {
		PageFactory.initElements(getDriver(), this);
	 }
	
	public void performclick(String buttonName) {
		try {
		switch(buttonName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "signinbutton":
		case "signin":
		case "signinbtn":
			Action.click(getDriver(), signinButton);
			break;
		case "contactus":
		case "contact":
		case "contactucbutton":
			Action.click(getDriver(), contactusButton);
			break;
			
		default:
			throw new TestException("Invalid action :" +buttonName);
		
		}
		}
		catch(Exception e) {
			throw new TestException("failed while performing "+buttonName +" action"+ e.getMessage());
		}
	}
	
	public void isPageDisplayed() {
		try {
			if(!contactusButton.isDisplayed())
				throw new TestException("Home page is not displayed");
	        if(getDriver().getTitle().equals("My Store")) {
		      System.out.println("Home page displayed");
	          }
	        else {
		      throw new TestException("Error occured while loading Home Page");
	          }
		}
		catch(Exception e) {
			throw new TestException("Home page is not displayed"+e.getMessage());
		}
	}
	
	
	
	
}
