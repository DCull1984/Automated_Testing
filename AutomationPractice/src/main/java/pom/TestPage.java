package pom;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TestPage 
{
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	private WebElement searchBox;
	
	@FindBy(linkText = "Printed Summer Dress")
	private WebElement checkFor;
	
	public void searchFor(String text)
	{
		searchBox.sendKeys(text);
		searchBox.submit();
		
		assertEquals(true, checkFor.isDisplayed());
	}
	
}
