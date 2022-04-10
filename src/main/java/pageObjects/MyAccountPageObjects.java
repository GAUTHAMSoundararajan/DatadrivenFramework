package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class MyAccountPageObjects extends Base {
	@FindBy(id = "email_create")
	WebElement emailAddressTxtBox;
	@FindBy(id = "SubmitCreate")
	WebElement createAccountBtn;
	@FindBy(id = "email")
	WebElement emailTxtBox;
	@FindBy(id = "passwd")
	WebElement pwdTxtBox;
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement forgetPwdButton;
	@FindBy(id = "SubmitLogin")
	WebElement signInButton;
	
	public MyAccountPageObjects() {
		PageFactory.initElements(getDriver(), this);
	 }
	public void isPageDisplayed() {
		try {
			if(!signInButton.isDisplayed())
				throw new TestException("sign in page is not displayed");
	        if(getDriver().getTitle().equals("Login - My Store")) {
		      System.out.println("sign in pag is displayed");
	          }
	        else {
		      throw new TestException("Error occured while loading sign in page");
	          }
		}
		catch(Exception e) {
			throw new TestException("sign in page is not displayed"+e.getMessage());
		}
	}
	public void performclick(String buttonName) {
		try {
		switch(buttonName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "signin":
		case "submitlogin":
			Action.click(getDriver(), signInButton);
			break;
		case "forgotpwd":
		case "forgotpassword":
			Action.click(getDriver(),forgetPwdButton);
			break;
		case "createanaccount":
		case "submitcreate":
		case "create":
			Action.click(getDriver(),createAccountBtn);
			break;
		default:
			throw new TestException("Invalid action :" +buttonName);
		
		}
		}
		catch(Exception e) {
			throw new TestException("failed while performing "+buttonName +" action"+ e.getMessage());
		}
	}	
	
	public void enterDetails(String fieldName , String value) {
		try {
		switch(fieldName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "createemail":
			Action.type(emailAddressTxtBox, value);
			break;
		case "emailaddress":
		case "email":
		case "signinemail":
			Action.type(emailTxtBox, value);
			break;
		case "pwd":
		case "password":
			Action.type(pwdTxtBox, value);
			break;
		default:
			throw new TestException("Invalid input for basic details: "+fieldName);
			
		}
		}
		catch(Exception e) {
			throw new TestException("Failed due to following error :"+e.getMessage());
		}
		
	}
}
