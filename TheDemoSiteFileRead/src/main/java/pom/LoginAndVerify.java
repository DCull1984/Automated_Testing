package pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginAndVerify 
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
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement ChangeToLogin;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement LogUser;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement UserPass;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement TestLogin;

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement Success;
	
	public void LogAndVerify(Actions action) throws IOException, InterruptedException 
	{
		extent = new ExtentReports(
				"C:\\Users\\Admin\\eclipse-workspace\\TheDemoSiteFileRead\\Report.html", true);
		test = extent.startTest("verify web page");

		FileInputStream file = new FileInputStream(
				"C:\\Users\\Admin\\eclipse-workspace\\TheDemoSiteFileRead\\LoginData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);

			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();

			/*action.click(checkElement)
			.sendKeys(USER, user)
			.sendKeys(PASSWORD, pass)
			.click(saveButton)
			.click(ChangeToLogin)
			.sendKeys(LogUser, user)
			.sendKeys(UserPass, pass)
			.click(TestLogin)
			.perform();*/
			
			checkElement.click();
			USER.sendKeys(user);
			PASSWORD.sendKeys(pass);
			saveButton.click();
						
			ChangeToLogin.click();
			LogUser.sendKeys(user);
			UserPass.sendKeys(pass);
			TestLogin.click();
			
			test.log(LogStatus.INFO, "Created User: " + user);
			/*if(Success == Success.getAttribute("**Successful Login**")))
			{
				test.log(LogStatus.PASS, "Creating Users: " + user);
			}
			else 
			{
				test.log(LogStatus.FAIL, "Error Creating User: " + user);
			}*/
		}

		extent.endTest(test);
		extent.flush();
	}
}
