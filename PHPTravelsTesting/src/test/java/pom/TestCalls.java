package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestCalls {
	WebDriver driver;
	Actions action;
	
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Downloads\\ExtentReport\\log.html", true);
	ExtentTest test;
	
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", 
				"C:/Users/Admin/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
		
		driver = new FirefoxDriver();
		action = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net");	
		
		test = extent.startTest("verify web page");	
	}
	
	@After
	public void teardown() throws InterruptedException
	{		
		
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		extent.endTest(test);
		extent.flush();
		
		driver.quit();
	}
	
	@Test
	public void booking()
	{
		MainTest mainTest = PageFactory.initElements(driver, MainTest.class);
		mainTest.search("London", action, driver);
		
		test.log(LogStatus.INFO, "Browser search");
	
		
	}
}