package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class MainTest {
	
	//FirefoxDriver driver;
	WebDriver driver;
	@Before
	public void setup() 
	{
		System.setProperty("webdriver.gecko.driver", 
				"C:/Users/Admin/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.thedemosite.co.uk");
		
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	@Ignore
	@Test
	public void methodTest() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://www.thedemosite.co.uk");
		Thread.sleep(2000);
	}
	
	@Ignore
	@Test
	public void moveToLogin() throws InterruptedException
	{
		WebElement checkElement = driver.findElement(By.xpath
				("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		checkElement.click();
		Thread.sleep(2000);
	}
	
	@Ignore
	@Test
	public void addLogin() throws InterruptedException
	{
		WebElement checkElement = driver.findElement(By.xpath
				("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		checkElement.click();
		
		WebElement userName = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		WebElement password = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		WebElement saveButton = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		
		userName.sendKeys("David");
		password.sendKeys("Root");
		saveButton.click();
		
		Thread.sleep(2000);
	}
	
	@Test
	public void loginVerification() throws InterruptedException
	{
		WebElement checkElement = driver.findElement(By.xpath
				("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		checkElement.click();
		
		WebElement userName = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		WebElement password = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		WebElement saveButton = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		
		userName.sendKeys("David");
		password.sendKeys("Root");
		saveButton.click();
		
		WebElement login = driver.findElement(By.xpath
				("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		login.click();
		
		WebElement name = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		WebElement passwd = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		WebElement loginTest = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		
		name.sendKeys("David");
		passwd.sendKeys("Root");
		loginTest.click();
		
		WebElement success = driver.findElement(By.xpath
				("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		success.isDisplayed();
		
		Thread.sleep(3000);
	}
}