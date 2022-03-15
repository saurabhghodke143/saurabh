package test123;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import AMAZON.AmazonSignIn;
import AMAZON.AmazonSignOut;
import AMAZON.AmazonYourOrders;
import base.Browser;
import utils.UtilityAmazon;

public class VerifyYourOrders extends Browser {

	private WebDriver driver;
	private AmazonSignIn amazonSignIn;
	private AmazonYourOrders amazonYourOrders;
	private AmazonSignOut amazonSignOut;
	String TestID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browsername)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browsername.equals("Chrome"))
		{
			driver = launchChromeBrowser();
		}
		
		if(browsername.equals("Edge"))
		{
			driver = launchEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	@BeforeClass
	public void createAnObject()
	{
		
		 amazonSignIn = new AmazonSignIn(driver); // AMAZON SIGN ACCOUNT STARTING
		 amazonYourOrders = new AmazonYourOrders(driver);
		 amazonSignOut = new AmazonSignOut(driver);
	}
	
	@BeforeMethod
	public void launchAplication() throws EncryptedDocumentException, IOException
	{
		System.out.println("launchAplication");
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		 
		amazonSignIn.clickOnAll();
		amazonSignIn.clickOnSignIn();
		
		String email = UtilityAmazon.getDataFromExcelSheet("saurabh", 2, 0);
		
		amazonSignIn.sendDataOnEmailid(email);
		amazonSignIn.clickOnContinueButton();
		
		String password = UtilityAmazon.getDataFromExcelSheet("saurabh", 2, 1);
		
		amazonSignIn.sendDataOnPassword(password);
		amazonSignIn.clickOnCheckBox();
		amazonSignIn.clickOnSignInSubmit();
		
	}
	
	@Test
	public void test() throws InterruptedException
	{
		TestID = "103";
		
		System.out.println("Test");
		Thread.sleep(5000);
		amazonYourOrders.moveOnAccountAndList();
		Thread.sleep(3000);
		amazonYourOrders.clickOnYourOrders();
		Thread.sleep(3000);
		amazonYourOrders.clickOnOrders();
		Thread.sleep(3000);
		amazonYourOrders.clickOnBuyAgain();
		Thread.sleep(3000);
		amazonYourOrders.clickOnNotYetShipped();
		Thread.sleep(3000);
		amazonYourOrders.clickOnCancelOrders();
		String s = driver.getWindowHandle();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void signOut(ITestResult result) throws IOException, InterruptedException
	{
		System.out.println("signOut");
		
		if(ITestResult.FAILURE == result.getStatus())
		{
		UtilityAmazon.takeScreenshot(driver, TestID);
		}
		
		Thread.sleep(3000);
		amazonSignOut.moveOnAccountsAndList();
		Thread.sleep(3000);
		amazonSignOut.clickOnSignOut();
	}
	
	@AfterClass
	public void clearPomObject()
	{
		System.out.println("clearPomObject");
		
		 amazonSignIn = null;
		 amazonYourOrders = null;
		 amazonSignOut = null;
		
	}
	
	@AfterTest
	public void clearBrowser()
	{
		System.out.println("clearBrowser");
		
		driver.quit();
		driver = null;
		System.gc();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
