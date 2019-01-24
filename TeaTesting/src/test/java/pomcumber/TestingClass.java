package pomcumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestingClass 
{
	WebDriver driver;
		
	ExtentTest	test;
	
	@Before
	public void setup()
	{	
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
				
		test = TestBuilder.report.startTest("PomCumber Testing");
		
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() 
	{	
		driver.get(Constants.HOME);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() 
	{
		test.log(LogStatus.INFO, "Menu Navigation Test Started");
		WebElement menu = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[13]/div/ul/li[3]/a"));
		menu.click();	
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() 
	{
		test.log(LogStatus.PASS, "Menu Page Found");
		assertEquals("Menu",driver.getTitle());
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button()  
	{
		test.log(LogStatus.INFO, "Checkout Test Started");
		WebElement checkout = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[13]/div/ul/li[5]/a"));
		checkout.click();	
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()  
	{
		test.log(LogStatus.PASS, "Checkout Page Found");
		assertEquals(Constants.CHECKOUT, driver.getCurrentUrl());
	}
	
	@After
	public void teardown()
	{		
		driver.close();
	}

}
