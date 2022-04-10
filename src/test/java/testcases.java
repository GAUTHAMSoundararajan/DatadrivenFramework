
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class testcases {
	
	@Test
//	public void testing() throws InterruptedException, IOException {
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\workspace\\DatadrivenFramework\\drivers\\chromedriver.exe" );
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.findElement(By.name("Submit")).click();
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	      FileUtils.copyFile(scrFile,new File("C:\\Users\\hp\\Desktop\\hhhhh.jpg"));
//		driver.findElement(By.partialLinkText("Proceed to checkout")).click();
//		WebElement table = driver.findElement(By.id("cart_summary"));
//		
//	/*	Actions actions = new Actions(driver);
//	    actions.moveToElement(driver.findElement(By.partialLinkText("Proceed to checkout"))).doubleClick().build().perform();*/
//	 
//	   // actions.click().build().perform();
//	   // actions.clickAndHold();
//	   // actions.doubleclick();
//	   // actions.dragAndDrop(source webelement, targetwebelement);// drag and drop functionality also covered
//		//WebElement table = driver.findElement(By.id("cart_summary"));
//		System.out.println("sdfdsf");
//		ArrayList<String> Header = new ArrayList<>();
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		LinkedHashMap<String, String> rowValue = new LinkedHashMap<>();
//		System.out.println(rows.size());
//		for(int index =0;index<rows.size();index++) {
//			String styleAttribute = rows.get(index).getAttribute("style");
//			
//		List<WebElement> head = rows.get(index).findElements(By.tagName("th"));
//		if(head.size() ==0 && styleAttribute.isEmpty()) {
//		String value = "";
//			
//			List<WebElement> col = rows.get(index).findElements(By.tagName("td"));	
//			for(int colIndex =0;colIndex<col.size();colIndex++ ) {
//				
//				 value = value+"Col"+String.valueOf(colIndex+1)+":"+col.get(colIndex).getText()+" ";
//				}
//			System.out.println("87 : "+value);
//			rowValue.put("Row"+String.valueOf(index+1), value);
//			}
//		else {
//			for(int headindex =0;headindex<head.size();headindex++) {
//				String data = head.get(headindex).getText();
//				Header.add(data);
//					}
//			}
//		
//		}
//		System.out.println(Header);
//		System.out.println(rowValue);
//		}
		
//		}
		
//		System.out.println("Title : "+driver.getTitle());
//		driver.findElement(By.linkText("Sign in")).click();
//		driver.findElement(By.partialLinkText("Sign")).click();
//		
//		//driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();  
//		WebElement ele =driver.findElement(By.id("email_create"));
//		ele.sendKeys("gautham@gmail.com");
//		
//		//driver.findElement(By.linkText(""));
//		//driver.findElement(By.partialLinkText(""));
//		//ele.getAttribute(arg0);
//
//		System.out.println("Title1 : "+driver.getTitle());
//		driver.findElement(By.id("SubmitCreate")).click();
//		Thread.sleep(10000);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
//
//		System.out.println("Title2 : "+driver.getTitle());
//		String text =driver.findElement(By.id("email")).getAttribute("value");
//		String text1 =driver.findElement(By.id("email")).getText();
//		String text2 =driver.findElement(By.id("email")).getAttribute("innerText");
//		
//		FileInputStream fio = new FileInputStream("C:\\Users\\hp\\Desktop\\Test data.xlsx");
//		//HSSFWorkbook work = new HSSFWorkbook(fio);
//		//HSSFSheet sht = work.getSheetAt(0);
//		XSSFWorkbook work = new XSSFWorkbook(fio);
//		XSSFSheet sht = work.getSheetAt(0);
//		int noRoews = sht.getLastRowNum();
//		int rows = sht.getPhysicalNumberOfRows();
//		
//		System.out.println("khdhqwbd"+noRoews );
//		System.out.println("jgagshqgw"+rows);
//		for(int row=0;row<=rows;row++) {
//			int col = sht.getRow(row).getPhysicalNumberOfCells();
//			
//			
//			for(int col1 =0;col1<col;col1++) {
//		try {
//			String data = sht.getRow(row).getCell(col1).getStringCellValue();
//			System.out.println(data);
//		}
//		catch(Exception e) {
//			String data1 = sht.getRow(row).getCell(col1).getStringCellValue();
//			System.out.println(data1);
//		}
//			}
//	WebElement daysDropdown =	driver.findElement(By.id("days"));
//	List<WebElement> days = daysDropdown.findElements(By.tagName("option"));
//		for(WebElement element : days) {
//			if(element.getAttribute("value").equalsIgnoreCase("1")) {
//				element.click();
//			}
//		}
//		System.out.println("jejeje"+text);
//		System.out.println("jejejew"+text1);
//		System.out.println("jejejez"+text2);
//		
//	}
//	}
	
	
	public void testing1() throws InterruptedException, IOException {
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\workspace\\DemoFramework\\drivers\\chromedriver.exe" );
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://phptravels.com/demo/");
//		Class.
//		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
//		
//		Set<String> windowHandles = driver.getWindowHandles();
//		    for(String wh: windowHandles) {	
//		    driver.switchTo().window(wh);
//		    String ss = driver.getCurrentUrl();
//		    System.out.println(ss);
//		    if(ss.equalsIgnoreCase("https://phptravels.org/login"))
//		    break;
//		    }
//		driver.findElement(By.name("username")).sendKeys("gautham");
//		driver.findElement(By.id("inputPassword")).sendKeys("1234");
//		
//		WebElement wb = driver.findElement(By.xpath("//iframe[@title ='reCAPTCHA']"));
//		driver.switchTo().frame(wb);
//		driver.findElement(By.id("recaptcha-anchor")).click();
		
	}
	
	
	public void testing11() throws IOException, HeadlessException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\workspace\\DemoFramework\\drivers\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(scrFile,new File("C:\\Users\\hp\\Desktop\\proof1.jpg"));
		driver.findElement(By.partialLinkText("Sign in")).click();
//	    /*File scrFile = ((TakeScreenshot)driver).getScreenshotAs(outputType.FILE);
//	    FileUtils.copyFile(scrFile,new File("path where need to be stored"));

		System.out.println("Title :"+driver.getTitle());
		driver.findElement(By.name("login")).sendKeys("ram");
		driver.findElement(By.name("proceed")).click();
		 WebDriverWait wait = new WebDriverWait(driver, 5);
		    wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert = driver.switchTo().alert();
		  String alertMessage =   alert.getText();
		  System.out.println("Alert Message :"+alertMessage );
		  alert.accept();
		  try {
		  Class.forName("oracle.jdbc.OracleDriver");
		  String hostname ="hostname";
		  String username = "username";
		  String password = "password";
		  Connection  db = DriverManager.getConnection("jdbc:oracle:thin:@"+hostname,username,password);
		  }
		  catch (Exception e) {
			// TODO: handle exception
		}
		  driver.close();
		
	}
	
	
}//	public static void main(String[] args) {
//	
//	}
