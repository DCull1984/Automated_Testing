package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTest 
{
	
	
	@FindBy(xpath = "/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[1]/div/div[2]/a/span[1]")
	private WebElement findLocation;
	
	@FindBy(xpath = "/html/body/div[17]/ul/li/ul")
	private WebElement myDynamicElement;
	
	@FindBy(xpath = "/html/body/div[17]/ul/li/ul/li[1]")
	private WebElement cityName;
	
	@FindBy(name = "checkin")
	private WebElement checkInDate;
	
	@FindBy(name = "checkout")
	private WebElement checkOutDate;
	
	@FindBy(xpath = "/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[5]/button")
	private WebElement search;
	
	public void search(String text, Actions action, WebDriver driver)
	{
		action.click(findLocation)
		.sendKeys(findLocation, text)
		.perform();
		
		myDynamicElement = (new WebDriverWait(driver, 10))
			.until(ExpectedConditions
			.elementToBeClickable(cityName));
		
		action.click(myDynamicElement)
		.perform();
		
		action.sendKeys(checkInDate, "31/01/2019")
		.sendKeys(checkOutDate, "28/02/2019")
		.click(search)
		.perform();
	}
}
