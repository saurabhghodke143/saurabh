package AMAZON;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmzonHeaderPage {

	@FindBy(xpath="//a[@id='nav-logo-sprites']")       //  AMAZON HEADERPAGE WEBELEMENTS
	private WebElement amazon;
	
	@FindBy(xpath="//span[@id='glow-ingress-line2']")
	private WebElement selectYourAdress ;
	
	@FindBy(xpath="//select[@aria-describedby='searchDropdownDescription']")
	private WebElement allCategories ;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchINputField ;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchBar ;
	
	@FindBy(xpath="//span[contains(@class,'icp-nav-flag icp-')]")
	private WebElement flag ;
	
	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accountsAndList ;
	
	@FindBy(xpath="//a[@id='nav-orders']")
	private WebElement returnsAndOrders ;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	private WebElement addToCart ;
	
	
	


	private WebDriver driver ;
	private Actions actions ;
	
	public AmzonHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		actions = new Actions(driver);
	}
	
	public void clickOnAmazon()
	{
		amazon.click();//
	}
	
	public void clickOnSelectYourAdress()
	{
		selectYourAdress.click();
	}
	
	public void clickOnAllCategories()
	{
		allCategories.click();
	}
	
	public void clickOnSearchINputField()
	{
		searchINputField.sendKeys("mobiles under 10000");;
	}

	public void clickOnSearchBar()
	{
		searchBar.click();
	}
	
	public void clickOnFlag()
	{
		actions.moveToElement(flag).perform();
	}
	
	public void clickOnAccountsAndList()
	{
		actions.moveToElement(accountsAndList).perform();
	}
	
	public void clickOnReturnsAndOrders()
	{
		returnsAndOrders.click();
	}
	
	public void clickOnAddToCart()
	{
		addToCart.click();
	}
	
	
	
	
}
