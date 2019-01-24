package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MercuryTests 
{
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")
	private WebElement registerUser;
	
	@FindBy(name = "firstName")
	private WebElement foreName;
	
	@FindBy(name = "lastName")
	private WebElement surName;
	
	@FindBy(name = "phone")
	private WebElement mobileNo;
	
	@FindBy(id = "userName")
	private WebElement eMail;
	
	@FindBy(name = "address1")
	private WebElement street;
	
	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(name = "state")
	private WebElement county;
	
	public void createUser(Actions action)
	{
		action.click(registerUser).perform();
		
		action.sendKeys(foreName, "David")
		.sendKeys(surName, "Cull")
		.sendKeys(mobileNo, "07719515836")
		.sendKeys(eMail, "squallc84@ntlworld.com")
		.sendKeys(street, "Gregson Ave")
		.sendKeys(city, "Gosport")
		.sendKeys(county, "Hampshire")
		.perform();
	}
}
