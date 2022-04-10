package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.TestException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import actionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentManager;

public class Base {
	public static Properties prop;
	//public static WebDriver driver;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return  driver.get();
		
	}
@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
public void loadConfig() {
	ExtentManager.setExtent();
	DOMConfigurator.configure("log4j.xml");
	try {
	 prop = new Properties();
	FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\configiration\\config.properties");
	prop.load(fi);
	
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}

public static void launchApp(String browserName) {
	try {
		System.out.println("Started launching browser");
	//String browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
	}
	else if (browserName.equalsIgnoreCase("IE")) {
		WebDriverManager.iedriver().setup();
		driver.set(new InternetExplorerDriver());
	}
	else if (browserName.equalsIgnoreCase("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver.set(new FirefoxDriver());
	}
	else if(browserName.equalsIgnoreCase("safari")) {
		WebDriverManager.safaridriver().setup();
		driver.set(new SafariDriver());
	}
	else {
		throw new TestException("Please enter valid browser name. Expected chrome or ie or firefox or safari But Actual :"+ browserName);
	}
	getDriver().manage().window().maximize();
	getDriver().manage().deleteAllCookies();
	Action.implicitWait(getDriver(), Integer.parseInt(prop.getProperty("implicitWait")));
	Action.pageLoadTimeOut(getDriver(), Integer.parseInt(prop.getProperty("pageLoadTimeOut")));
	getDriver().get(prop.getProperty("url"));	
	}
	catch (Exception e) {
		throw new TestException("Failed while launching browser"+ e.getMessage());
	}
}
@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
public void afterSuite() {
	ExtentManager.endReport();
}

}
