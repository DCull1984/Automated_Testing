package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderWithoutWaitTest 
{
	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")
	private WebElement dropBox;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/div[2]/ul/li[1]/div[1]/a/img")
	private WebElement casual;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a")
	private WebElement dress;
	
	@FindBy(name = "Submit")
	private WebElement order;
	
	public void selectDrop()
	{
		dropBox.click();
		casual.click();
		dress.click();
		order.submit();
	}
}
