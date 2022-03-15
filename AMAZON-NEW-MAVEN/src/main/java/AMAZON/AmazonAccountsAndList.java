package AMAZON;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonAccountsAndList {

	@FindBy(xpath="//a[@id='nav-link-accountList']")
	private WebElement accountsAndList;
	
	@FindBy(xpath="//span[text()='Your Account']")
	private WebElement yourAccount;
	
	@FindBy(xpath="//span[text()='Edit addresses for orders and gifts']")
	private WebElement yourAdress ;
	
	@FindBy(xpath="//div[@id='ya-myab-plus-address-icon']")
	private WebElement addAdress ;
	

	@FindBy(xpath="//span[@id='address-ui-widgets-countryCode']")   //(//span[@data-action='a-dropdown-button'])[1]  //(//span[@class='a-button-inner'])[1]
	private WebElement country ;
	
	@FindBy(xpath="//a[text()='India']")
	private WebElement india ;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressFullName']")
	private WebElement fullName ;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	private WebElement moibileNumber ;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")
	private WebElement pincode ;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']")
	private WebElement appartment ;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']")
	private WebElement village ;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-landmark']")
	private WebElement landmark ;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressCity']")
	private WebElement city ;
	
	@FindBy(xpath="//span[@id='address-ui-widgets-enterAddressStateOrRegion']")
	private WebElement chooseState ;
	
	@FindBy(xpath="//a[text()='MAHARASHTRA']")
	private WebElement maharashtra ;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-use-as-my-default']")
	private WebElement checkBox ;
	
	@FindBy(xpath="//span[text()=' Select an Address Type ']")
	private WebElement adressType ;
	
	@FindBy(xpath="//a[text()=' Home (7 am – 9 pm delivery) ']")
	private WebElement adressTiming ;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement addAdressButton ;
	
	@FindBy(xpath="(//a[text()='Remove'])[1]")
	private WebElement remove ;
	
	@FindBy(xpath="//span[@id='deleteAddressModal-0-submit-btn']")   ////span[text()='Yes']
	private WebElement yes ;
	
	
	private WebDriver driver;
	private Actions actions;

	public AmazonAccountsAndList(WebDriver driver)                                   ///hrshrttrt
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver); 
		
	}
	
	public void moveOnAccountsAndList ()
	{
		actions.moveToElement(accountsAndList).perform();
	}

	public void clickOnYourAccount ()
	{
		yourAccount.click();
	}

	public void clickOnYourAdress ()
	{
		yourAdress.click();
	}
	
	public void clickOnAddAdress()
	{
		addAdress.click();
	}
	
	public void clickOnCountry ()
	{
		country.click();
	}
	
	public void clickOnIndia ()
	{
		india.click();
	}
	
	public void sendDatanFullName ()
	{
		fullName.sendKeys("saurabh ghodke");
	}
	
	public void sendDataMObileNumber ()
	{
		moibileNumber.sendKeys("7666176143");
	}
	
	public void clickOnPincode ()
	{
		pincode.sendKeys("431509");
	}
	
	public void clickOnAppartment ()
	{
		appartment.sendKeys("near jain temple,jintur");
	}
	
	public void sendDataVillage ()
	{
		village.sendKeys("main road jintur");
	}
	
	public void sendDataLandmark ()
	{
	landmark.sendKeys("near chavandke grocery shop,jintur");	
	}
	
	public void sendDataCity ()
	{
		city.sendKeys("parbhani");
	}

	public void clickOnChooseState ()
	{
		chooseState.click();
	}
	
	
	public void clickOnMaharashta ()
	{
		maharashtra.click();
	}
	
	public void clickOnCheckBox ()
	{
		checkBox.click();
	}
	
	public void clickOnAdressType ()
	{
		adressType.click();
	}
	
	public void selectAdessTiming ()
	{
		adressTiming.click();
	}
	
	public void clickOnAddAdressButton ()
	{
		addAdressButton.click();
	}
	
	
	public void clickOnRemove ()
	{
		remove.click();
	}
	
	public void clickOnYes ()
	{
		yes.click();
	}
	
	
}
