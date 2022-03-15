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

import AMAZON.AmazonAccountsAndList;
import AMAZON.AmazonSignIn;
import AMAZON.AmazonSignOut;
import base.Browser;
import utils.UtilityAmazon;

public class VerfyAccountsAndList extends Browser {

	private WebDriver driver;
	private AmazonSignIn amazonSignIn;
	private AmazonAccountsAndList amazonAccountsAndList;
	private AmazonSignOut amazonSignOut;
	String testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browsername)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if (browsername.equals("Chrome"))
		{
			driver =launchChromeBrowser();
		}
		
		if (browsername.equals("Edge"))
		{
			driver = launchEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}
	
	@BeforeClass
	public void createAnObject()
	{
		System.out.println("CreateAnObject");
		
		amazonSignIn = new AmazonSignIn(driver);
		amazonAccountsAndList = new AmazonAccountsAndList(driver);  //YOURACCOUNT
		 amazonSignOut = new AmazonSignOut(driver);
		
		
	}
	
	@BeforeMethod
	public void loginToApplication() throws InterruptedException, EncryptedDocumentException, IOException
	{
		System.out.println("BeforeMethod");
		
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
		testID = "101";
		
		System.out.println("Test");
		
		Thread.sleep(3000);
		amazonAccountsAndList.moveOnAccountsAndList();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnYourAccount();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnYourAdress();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnAddAdress();
		Thread.sleep(6000);
		amazonAccountsAndList.clickOnCountry();
		Thread.sleep(6000);
		amazonAccountsAndList.clickOnIndia();
		Thread.sleep(3000);
		amazonAccountsAndList.sendDatanFullName();
		Thread.sleep(3000);
		amazonAccountsAndList.sendDataMObileNumber();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnPincode();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnAppartment();
		Thread.sleep(3000);
		amazonAccountsAndList.sendDataVillage();
		Thread.sleep(3000);
		amazonAccountsAndList.sendDataLandmark();
		Thread.sleep(3000);
		amazonAccountsAndList.sendDataCity();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnChooseState();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnMaharashta();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnCheckBox();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnAdressType();
		Thread.sleep(3000);
		amazonAccountsAndList.selectAdessTiming();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnAddAdressButton();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnRemove();
		Thread.sleep(3000);
		amazonAccountsAndList.clickOnYes();
		Thread.sleep(3000);
		ArrayList<String> address03 = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(address03.get(0));
	}
	
	@AfterMethod
	public void signOut (ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
		UtilityAmazon.takeScreenshot(driver, testID);
		}
		
		System.out.println("signOut");
		Thread.sleep(3000);
		amazonSignOut.moveOnAccountsAndList();
		Thread.sleep(3000);
		amazonSignOut.clickOnSignOut();
	}
	
	@AfterClass
	public void clearPomClassObject ()
	{
		System.out.println("clearPomClassObject");
		
		amazonSignIn = null;
		amazonAccountsAndList = null;
		amazonSignOut=null;
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
