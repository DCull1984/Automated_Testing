package pom;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderWithWait 
{
	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")
	private WebElement hoverSelect;
	
	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[1]/a")
	private WebElement myDynamicElement;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a")
	private WebElement selectedInformation;
	
	@FindBy(name = "Submit")
	private WebElement buyItem;
	
	public void navSelect(Actions action, WebDriver driver)
	{
		action.moveToElement(hoverSelect).perform();
		
		myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath
						("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[1]/a")));
		
		myDynamicElement.click();
		
		selectedInformation.click();
		
		action.moveToElement(buyItem).click().perform();
		
	}
	
}


