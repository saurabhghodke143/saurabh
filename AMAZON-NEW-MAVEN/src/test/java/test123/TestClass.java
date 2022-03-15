package test123;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AMAZON.AmazonAccountsAndList;
import AMAZON.AmazonAddToCart;
import AMAZON.AmazonYourOrders;
import AMAZON.AmzonHeaderPage;
import utils.UtilityAmazon;
import AMAZON.AmazonSignIn;
import AMAZON.AmazonSignOut;

public class TestClass {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		
		 System.setProperty("webdriver.chrome.driver","C:\\chrome.exe\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();

			AmazonSignIn amazonSignIn = new AmazonSignIn(driver); // AMAZON SIGN ACCOUNT STARTING
			amazonSignIn.clickOnAll();
			amazonSignIn.clickOnSignIn();
			String email = UtilityAmazon.getDataFromExcelSheet("saurabh", 2, 0);
			amazonSignIn.sendDataOnEmailid(email);
			amazonSignIn.clickOnContinueButton();
			String password = UtilityAmazon.getDataFromExcelSheet("saurabh", 2, 1);
			amazonSignIn.sendDataOnPassword(password);
			amazonSignIn.clickOnCheckBox();
			amazonSignIn.clickOnSignInSubmit();
		
			
		
		
			AmzonHeaderPage amazonHeaderPage = new AmzonHeaderPage(driver);  // AMAZON HEADERPAGE WEBELEMENTS
			amazonHeaderPage.clickOnAmazon();
			amazonHeaderPage.clickOnSelectYourAdress();
			driver.navigate().back();
			amazonHeaderPage.clickOnAllCategories();
			amazonHeaderPage.clickOnSearchINputField();
			amazonHeaderPage.clickOnSearchBar();
			amazonHeaderPage.clickOnFlag();
			amazonHeaderPage.clickOnAccountsAndList();
			driver.navigate().back();
			amazonHeaderPage.clickOnReturnsAndOrders();
			driver.navigate().back();
			amazonHeaderPage.clickOnAddToCart();
			driver.navigate().back();
		
		
			AmazonAddToCart amazonAddToCart = new AmazonAddToCart(driver);  // ADD TO CART MOBILE
			amazonAddToCart.clickOnSearchBar();
			amazonAddToCart.clickOnSearch();
			amazonAddToCart.clickOnMobileImage();
			ArrayList<String> adress = new  ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(adress.get(1));
			Thread.sleep(5000);
			amazonAddToCart.clickOnAddToCart();
		    Thread.sleep(5000);
	    	ArrayList<String> address01 = new ArrayList<String>(driver.getWindowHandles());
	    	driver.switchTo().window(address01.get(0));
			amazonAddToCart.clickOnAddToCartSymbol();
			ArrayList<String> address02 = new ArrayList<String>(driver.getWindowHandles());
	    	driver.switchTo().window(address02.get(0));
			
			AmazonAccountsAndList amazonAccountsAndList = new AmazonAccountsAndList(driver);  //YOURACCOUNT
			amazonAccountsAndList.moveOnAccountsAndList();
			amazonAccountsAndList.clickOnYourAccount();
			amazonAccountsAndList.clickOnYourAdress();
			amazonAccountsAndList.clickOnAddAdress();
			amazonAccountsAndList.clickOnCountry();
			amazonAccountsAndList.clickOnIndia();
			amazonAccountsAndList.sendDatanFullName();
			amazonAccountsAndList.sendDataMObileNumber();
			amazonAccountsAndList.clickOnPincode();
			amazonAccountsAndList.clickOnAppartment();
			amazonAccountsAndList.sendDataVillage();
			amazonAccountsAndList.sendDataLandmark();
			amazonAccountsAndList.sendDataCity();
			amazonAccountsAndList.clickOnChooseState();
			amazonAccountsAndList.clickOnMaharashta();
			amazonAccountsAndList.clickOnCheckBox();
			amazonAccountsAndList.clickOnAdressType();
			amazonAccountsAndList.selectAdessTiming();
			amazonAccountsAndList.clickOnAddAdressButton();
			ArrayList<String> address03 = new ArrayList<String>(driver.getWindowHandles());
	    	driver.switchTo().window(address03.get(0));
			
	
//			AmazonYourOrders amazonYourOrders = new AmazonYourOrders(driver);
//			amazonYourOrders.moveOnAccountAndList();
//			amazonYourOrders.clickOnYourOrders();
//			amazonYourOrders.clickOnOrders();
//			amazonYourOrders.clickOnBuyAgain();
//			amazonYourOrders.clickOnNotYetShipped();
//			amazonYourOrders.clickOnCancelOrders();
//			Thread.sleep(5000);
//			ArrayList<String> address04 = new ArrayList<String>(driver.getWindowHandles());
//	    	driver.switchTo().window(address04.get(0));
		
		
			AmazonSignOut amazonSignOut = new AmazonSignOut(driver);
			amazonSignOut.moveOnAccountsAndList();
			amazonSignOut.clickOnSignOut();
			
			

        System.out.println("finish");

			
		
		
		
	}
	
}
