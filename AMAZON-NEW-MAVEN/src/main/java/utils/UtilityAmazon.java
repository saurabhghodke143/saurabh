package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityAmazon {

	
	public static void takeScreenshot(WebDriver driver,String testId) throws IOException
	{
	    Date date = new Date();
	    String dateAndTime = date.toString().replace(":", "_").replace(" ", "_");
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\SNAPSHOT\\Test"+testId+dateAndTime+".jpg");
		FileHandler.copy(source, dest);
		
	}
	
	public static String getDataFromExcelSheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String data = " ";
	
		FileInputStream file = new FileInputStream("C:\\Users\\KADSAWANGI\\Documents\\saurabh.xlsx");
		Workbook value = WorkbookFactory.create(file);
		
		try
		{
	        data = value.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		
		catch(IllegalStateException i)
		{
		    double	data1 = value.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		
		 long a = (long)data1;
		 
		 String s = String.valueOf(a);
		 
		 data = s;
		 
		}
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
