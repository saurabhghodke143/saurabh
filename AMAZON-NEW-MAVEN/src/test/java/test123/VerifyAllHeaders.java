package test123;

import java.io.File;
import java.io.IOException;
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
import AMAZON.AmzonHeaderPage;
import base.Browser;
import utils.UtilityAmazon;

public class VerifyAllHeaders extends Browser {

	private WebDriver driver;
	private AmazonSignIn amazonSignIn;
	private AmzonHeaderPage amazonHeaderPage;
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
		
		System.out.println("launchBrowser");
		
		if (browsername.equals("Chrome"))
		{
			driver = launchChromeBrowser();
		}
		
		if (browsername.equals("Edge"))
		{
			driver = launchEdgeBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	

	@BeforeClass
	public void createAnObject()
	{
		System.out.println("createAnObject");
		
		  amazonSignIn = new AmazonSignIn(driver); // AMAZON SIGN ACCOUNT STARTING
		  amazonHeaderPage = new AmzonHeaderPage(driver);  // AMAZON HEADERPAGE WEBELEMENTS
		  amazonSignOut = new AmazonSignOut(driver);
	}
	
	@BeforeMethod
	public void lainchApplication() throws InterruptedException, EncryptedDocumentException, IOException
	{
		System.out.println("launch application");
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	  
		amazonSignIn.clickOnAll();
		Thread.sleep(3000);
		amazonSignIn.clickOnSignIn();
		Thread.sleep(3000);
		
		String email = UtilityAmazon.getDataFromExcelSheet("saurabh", 2, 0);
		
		amazonSignIn.sendDataOnEmailid(email);
		Thread.sleep(3000);
		amazonSignIn.clickOnContinueButton();
		Thread.sleep(3000);
		
		String password = UtilityAmazon.getDataFromExcelSheet("saurabh", 2, 1);
		
		amazonSignIn.sendDataOnPassword(password);
		Thread.sleep(3000);
		amazonSignIn.clickOnCheckBox();
		Thread.sleep(3000);
		amazonSignIn.clickOnSignInSubmit();
		

	}
	
	@Test
	public void test() throws InterruptedException
	{
		TestID = "104";
		
		System.out.println("Test");
		Thread.sleep(3000);
		amazonHeaderPage.clickOnAmazon();
		Thread.sleep(3000);
		amazonHeaderPage.clickOnSelectYourAdress();
		Thread.sleep(3000);
		driver.navigate().back();
		amazonHeaderPage.clickOnAllCategories();
		Thread.sleep(3000);
		amazonHeaderPage.clickOnSearchINputField();
		Thread.sleep(3000);
		amazonHeaderPage.clickOnSearchBar();
		Thread.sleep(3000);
		amazonHeaderPage.clickOnFlag();
		Thread.sleep(3000);
		amazonHeaderPage.clickOnAccountsAndList();
		Thread.sleep(3000);
		driver.navigate().back();
		amazonHeaderPage.clickOnReturnsAndOrders();
		Thread.sleep(3000);
		driver.navigate().back();
		amazonHeaderPage.clickOnAddToCart();
		Thread.sleep(3000);
		driver.navigate().back();
		
	}
	
	@AfterMethod
	public void signOut(ITestResult result) throws IOException, InterruptedException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
		UtilityAmazon.takeScreenshot(driver, TestID);
		}
		
		System.out.println("signOut");
		
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
		amazonHeaderPage = null;
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
