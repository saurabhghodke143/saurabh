package test123;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
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
import com.beust.jcommander.Parameter;

import AMAZON.AmazonAddToCart;
import AMAZON.AmazonSignIn;
import AMAZON.AmazonSignOut;
import base.Browser;
import utils.UtilityAmazon;

public class VerifyAddToCart extends Browser {

	private WebDriver driver;
	private AmazonSignIn amazonSignIn;
	private AmazonAddToCart amazonAddToCart;
	private AmazonSignOut amazonSignOut;
    private  JavascriptExecutor javascriptExecutor; 
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
			driver = launchChromeBrowser();
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
		System.out.println("createAnObject");
		
		 amazonSignIn = new AmazonSignIn(driver);
		 amazonAddToCart = new AmazonAddToCart(driver);  // ADD TO CART MOBILE
		 amazonSignOut = new AmazonSignOut(driver);
	}
	
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, EncryptedDocumentException, IOException
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
		testID = "102";
		
		System.out.println("Test");
		

		
		amazonAddToCart.clickOnSearchBar();
		Thread.sleep(3000);
		amazonAddToCart.clickOnSearch();
		Thread.sleep(3000);
		amazonAddToCart.clickOnMobileImage();
		ArrayList<String> adress = new  ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(adress.get(1));
		Thread.sleep(3000);
		amazonAddToCart.clickOnAddToCart();
	    Thread.sleep(3000);
    	ArrayList<String> address01 = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(address01.get(0));
    	Thread.sleep(3000);
		amazonAddToCart.clickOnAddToCartSymbol();
		Thread.sleep(3000);
		amazonAddToCart.clickOnDelete();
		ArrayList<String> address02 = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(address02.get(0));
	}
	
	@AfterMethod
	public void signOut(ITestResult result) throws InterruptedException, IOException
	{
		if (ITestResult.FAILURE == result.getStatus())
		{
		UtilityAmazon.takeScreenshot(driver, testID);
		}
		
		
     System.out.println("signOut");
		
		amazonSignOut.moveOnAccountsAndList();
		Thread.sleep(3000);
		amazonSignOut.clickOnSignOut();
	}
	
	@AfterClass
	public void ClearPomObject()
	{
		System.out.println("ClearPomObject");
		
		amazonSignIn = null;
		amazonAddToCart = null;
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
	
	
//	 amazonAddToCart = new AmazonAddToCart(driver);  // ADD TO CART MOBILE
//		amazonAddToCart.clickOnSearchBar();
//		amazonAddToCart.clickOnSearch();
//		amazonAddToCart.clickOnMobileImage();
//		amazonAddToCart.clickOnAddToCart();
//		amazonAddToCart.clickOnAddToCartSymbol();
//		driver.navigate().back();
	
	
}
