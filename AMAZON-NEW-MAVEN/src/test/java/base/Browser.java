package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {

	public static WebDriver launchChromeBrowser()
	{
		 System.setProperty("webdriver.chrome.driver","C:\\chrome.exe\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			 return driver;
	}
	
	public static WebDriver launchEdgeBrowser()
	{
		
		 System.setProperty("webdriver.edge.driver","C:\\Edge\\msedgedriver.exe");
		 WebDriver driver = new EdgeDriver();
		  return driver;	   
	}
	
	
	
	
	
	
	
	
	
	
}
