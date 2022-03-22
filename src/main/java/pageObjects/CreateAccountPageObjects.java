package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class CreateAccountPageObjects extends Base {

	@FindBy(id = "id_gender1")
	WebElement mrButton;
	@FindBy(id = "id_gender2")
	WebElement mrsButton;
	@FindBy(id = "customer_firstname")
	WebElement firstNameTxtBox;
	@FindBy(id = "customer_lastname")
	WebElement lastNameTxtBox;
	@FindBy(id = "email")
	WebElement emailTxtBox;
	@FindBy(id = "passwd")
	WebElement passwordTxtBox;
	@FindBy(id = "days")
	WebElement dayDropdown;
	@FindBy(id = "months")
	WebElement monthDropdown;
	@FindBy(id = "years")
	WebElement yearDropdown;
	@FindBy(id = "newsletter")
	WebElement newsLetterCheckBox;
	@FindBy(id = "optin")
	WebElement specialOfferCheckBox;
	@FindBy(id = "firstname")
	WebElement addressFirstNameTxtbox;
	@FindBy(id = "lastname")
	WebElement addressLastNameTxtbox;
	@FindBy(id = "company")
	WebElement companyTxtbox;
	@FindBy(id = "address1")
	WebElement address1Txtbox;
	@FindBy(id = "address2")
	WebElement address2Txtbox;
	@FindBy(id = "city")
	WebElement cityTxtbox;
	@FindBy(id = "id_state")
	WebElement stateDropDown;
	@FindBy(id = "postcode")
	WebElement postcodeTxtBox;
	@FindBy(id = "id_country")
	WebElement countryDropdown;
	@FindBy(id = "other")
	WebElement additionalInfoTxtBox;
	@FindBy(id = "phone")
	WebElement homePhoneTxtBox;
	@FindBy(id = "phone_mobile")
	WebElement mobilePhoneTxtBox;
	@FindBy(id = "alias")
	WebElement aliasTxtBox;
	@FindBy(id = "submitAccount")
	WebElement submitAcctBtn;
	

	public CreateAccountPageObjects() {
		PageFactory.initElements(getDriver(), this);
	 }
	
	
	public void enterDetails(String fieldName , String value) {
		try {
		switch(fieldName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "firstname":
		case "customerfirstname":
			Action.type(firstNameTxtBox, value);
			break;
		case "lastname":
		case "customerlastname":
			Action.type(lastNameTxtBox, value);
			break;
		case "email":
			Action.type(emailTxtBox, value);
			break;
		case "pwd":
		case "password":
			Action.type(passwordTxtBox, value);
			break;
		case"day":
		case "days":
			Action.selectByVisibleText(dayDropdown, value);
			break;
		case"mon":
		case "months":
		case "month":
			Action.selectByVisibleText(monthDropdown, value);
			break;
		case"year":
		case "years":
			Action.selectByVisibleText(yearDropdown, value);
			break;
		case "addressfirstname":
		   Action.type(addressFirstNameTxtbox, value);
		   break;
		case "addresslastname":
			Action.type(addressLastNameTxtbox, value);
			break;
		case "company":
		   Action.type(companyTxtbox, value);
		   break;
		case "address":
		case "address1":
		case "addressline1":
			Action.type(address1Txtbox, value);
			break;
		case "Addressline2":
		case "address2":
			Action.type(address2Txtbox, value);
			break;
		case "city":
			Action.type(cityTxtbox, value);
			break;
		case "state":
			Action.selectByVisibleText(stateDropDown, value);
			break;
		case "zipcode":
		case "postalcode":
			Action.type(postcodeTxtBox, value);
			break;
		case "country":
			Action.selectByVisibleText(countryDropdown, value);
			break;
		case "additionalinfo":
		case "additionalinformation":
			Action.type(additionalInfoTxtBox, value);
			break;
		case "homephone":
			Action.type(homePhoneTxtBox, value);
			break;
		case "mobilephone":
		    Action.type(mobilePhoneTxtBox, value);
		    break;
		case "assignanaddressaliasforfuturereference":
		case "aliasaddress":
		case "addressalias":
		case "alias":
			Action.type(aliasTxtBox, value);
			break;
		default:
			throw new TestException("Invalid input for basic details: "+fieldName);
			
		}
		}
		catch(Exception e) {
			throw new TestException("Failed due to following error :"+e.getMessage());
		}
		
	}
	
	public void isPageDisplayed() {
		try {
			if(!mrButton.isDisplayed())
				throw new TestException("Create a account page is not displayed");
	        if(getDriver().getTitle().equals("Login - My Store")) {
		      System.out.println("Create a account page is displayed");
	          }
	        else {
		      throw new TestException("Error occured while loading create account Page");
	          }
		}
		catch(Exception e) {
			throw new TestException("create account page is not displayed"+e.getMessage());
		}
	}
	
	
	public void performclick(String buttonName) {
		try {
		switch(buttonName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "mr":
		case "mr.":
			Action.click(getDriver(), mrButton);
			break;
		case "mrs":
		case "mrs.":
			Action.click(getDriver(),mrsButton);
			break;
		case "signupforournewsletter!":
		case "newsletter":
		case "signupforournewsletter":
			Action.click(getDriver(),newsLetterCheckBox);
			break;
		case "receivespecialoffersfromourpartners!":
		case "receivespecialoffersfromourpartners":
		case "specialoffercheckBox":
			Action.click(getDriver(), specialOfferCheckBox);
			
		case "register":
		case "submit":
			Action.click(getDriver(),submitAcctBtn);
			
		default:
			throw new TestException("Invalid action :" +buttonName);
		
		}
		}
		catch(Exception e) {
			throw new TestException("failed while performing "+buttonName +" action"+ e.getMessage());
		}
	}	
	
	
	
}
