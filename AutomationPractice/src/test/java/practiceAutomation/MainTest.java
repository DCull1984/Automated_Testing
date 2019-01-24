package practiceAutomation;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.OrderWithWait;
import pom.OrderWithoutWaitTest;
import pom.TestPage;

public class MainTest 
{

	WebDriver driver;
	Actions action;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", 
				"C:/Users/Admin/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");	
		
		 action = new Actions(driver);
	}
	
	@After
	public void teardown()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.quit();
	}

	//@Ignore
	@Test
	public void firstConnect()
	{
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

	}
	
	//@Ignore
	@Test
	public void search()
	{
		TestPage search = PageFactory.initElements(driver, TestPage.class);
		
		search.searchFor("dresses");
		
		/*WebElement checkFor = driver.findElement(By.linkText("Printed Summer Dress"));
				
		assertEquals(true, checkFor.isDisplayed());*/
	}
	
	//@Ignore
	@Test
	public void selection()
	{
		OrderWithoutWaitTest select = PageFactory.initElements(driver, OrderWithoutWaitTest.class);
		
		select.selectDrop();
		
		/*WebElement casual = driver.findElement(By.xpath
				("/html/body/div/div[2]/div/div[3]/div[2]/div[2]/ul/li[1]/div[1]/a/img"));
		casual.click();
		
		WebElement dress = driver.findElement(By.xpath
				("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a"));
		dress.click();
		
		WebElement order = driver.findElement(By.name("Submit"));
		order.submit();*/
	}
	
	//@Ignore
	@Test
	public void select2()
	{
		OrderWithWait select = PageFactory.initElements(driver, OrderWithWait.class);
		
		select.navSelect(action, driver);
		
		/*WebElement hoverSelect = driver.findElement(By.xpath
				("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));
		action.moveToElement(hoverSelect).perform();
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath
						("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[1]/a")));
		myDynamicElement.click();*/
		
	}
	
}