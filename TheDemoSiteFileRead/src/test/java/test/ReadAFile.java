package test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadAFile 
{
		
	public void excelTest() throws IOException, InterruptedException 
	{

		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\TheDemoSiteFileRead\\LoginData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) 
		{
			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);

			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();
		}
	}
}
