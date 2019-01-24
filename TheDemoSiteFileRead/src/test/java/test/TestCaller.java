package test;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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

import pom.AddLoginDetail;
import pom.ChangeToLoginPage;
import pom.LoginAndVerify;


public class TestCaller {
	
	Constants path = new Constants();
	WebDriver driver;
	Actions action;
	
	/*ExtentReports extent; 
	ExtentTest test;*/
	
	@Before
	public void setup() 
	{
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		action = new Actions(driver);
		
		/*extent = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\TheDemoSiteFileRead\\Report.html", true);
		test = extent.startTest("verify web page");*/
		
		driver.manage().window().maximize();
		driver.get(path.URL1);
		
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		/*extent.endTest(test);
		extent.flush();*/
		driver.quit();
	}
	
	@Ignore
	@Test
	public void methodTest()
	{
		driver.manage().window().maximize();
		driver.get(path.URL1);
		
		//test.log(LogStatus.INFO, "Navigate and Maximize");
	}
	
	@Ignore
	@Test
	public void moveToLogin()
	{
		ChangeToLoginPage change = PageFactory.initElements(driver, ChangeToLoginPage.class);
		change.changePage(action);
		
		//test.log(LogStatus.INFO, "Move to LogIn");
	}
	
	@Ignore
	@Test
	public void addLogin() throws IOException, InterruptedException
	{
		AddLoginDetail userCreation = PageFactory.initElements(driver, AddLoginDetail.class);
						
		userCreation.createLogin();
		
		//test.log(LogStatus.INFO, "Creating Users");
	}
	
	//@Ignore
	@Test
	public void loginVerification() throws InterruptedException, IOException
	{
		LoginAndVerify verify = PageFactory.initElements(driver, LoginAndVerify.class);
		
		verify.LogAndVerify(action);
		
		/*WebElement success = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		success.isDisplayed();*/
		
		
		Thread.sleep(3000);
	}
}