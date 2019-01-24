package pom;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddLoginDetail 
{
	ExtentReports extent; 
	ExtentTest test;
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement checkElement;			
	
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement USER;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement PASSWORD;
	
	@FindBy(name = "FormsButton2")
	private WebElement saveButton; 
	
	public void createLogin() throws IOException, InterruptedException
	{
		extent = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\TheDemoSiteFileRead\\Report.html", true);
		test = extent.startTest("verify web page");
		
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\TheDemoSiteFileRead\\LoginData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) 
		{
			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);

			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();
		
			/*action.click(checkElement)
			.sendKeys(USER, user)
			.sendKeys(PASSWORD, pass)
			.moveToElement(saveButton)
			.click(saveButton)
			.perform();*/
			
			checkElement.click();
			USER.click();
			USER.sendKeys(user);
			PASSWORD.click();
			PASSWORD.sendKeys(pass);
			saveButton.click();
			
			test.log(LogStatus.INFO, "Creating Users: " + user);
		}
		
		extent.endTest(test);
		extent.flush();
	}
}
