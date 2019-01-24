package pom;

//import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.LogStatus;



public class TestPage 
{
	WebDriver driver;
	Actions action;
	ExtentReports report;
	ExtentReports conReport;
	ExtentTest test;
	ExtentTest test2;
	Constants path = new Constants();
	@Before
	public final void setUp()
	{
		System.setProperty("webdriver.gecko.driver", 
				"C:/Users/Admin/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
				
		report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\MecureyTours\\Report.html");
		driver = new FirefoxDriver();
		action = new Actions(driver);
		test = report.startTest("Start of Testing");
				
		driver.manage().window().maximize();
		driver.get(path.URL);
	}
	
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		report.endTest(test);
		report.flush();
		
		driver.quit();
	}
	
	@Test
	public void createUser()
	{
		MercuryTests userTesting = PageFactory.initElements(driver, MercuryTests.class);
		
		userTesting.createUser(action);
		
		test.log(LogStatus.INFO, "Browser search");
		
		//test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("screenshot-path"));
	}
}
